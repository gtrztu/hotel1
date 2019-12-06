package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import client.entity.Client;
import hotel.entity.Hotel;
import hotelservice.entity.Hotelservice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import login.entity.Login;
import reservation.entity.Reservation;
import room.entity.Room;
import typepaket.entity.TypePaket;

public class ReceptionistControler implements Initializable {
	@FXML
	private TextField uNameC;
	@FXML
	private TextField uFamalyC;
	@FXML
	private TextField PhoneC;
	@FXML
	private TextField AddresC;
	@FXML
	private TextField AgeC;
	@FXML
	private Button closeButton;
	@FXML
	private ComboBox<String> comboboxRoomType;
	@FXML
	private ComboBox<String> comboboxRoomNumber;
	@FXML
	private ComboBox<String> comboboxServiceType;
	@FXML
	private DatePicker Datebegin;
	@FXML
	private DatePicker Dateend;
	
	public void createClient() {
		String userC=uNameC.getText();
		String famalyC=uFamalyC.getText();
		String phoneC=PhoneC.getText();
		String addresC=AddresC.getText();
		
		int ageC=0;
		if(AgeC.getText().trim().isEmpty()==false)
		ageC=Integer.parseInt(AgeC.getText());
		
		String hotelRoomType=comboboxRoomType.getValue();
		
		int hotelRoomNumber=0;
		if(comboboxRoomNumber.getValue().trim().isEmpty()==false)
		hotelRoomNumber=Integer.parseInt(comboboxRoomNumber.getValue());
		
		String hotelServiceType=comboboxServiceType.getValue();
		LocalDate datebegin=Datebegin.getValue();
		LocalDate dateend=Dateend.getValue();
		
		if(uNameC.getText().trim().isEmpty()==false && uFamalyC.getText().trim().isEmpty()==false && PhoneC.getText().trim().isEmpty()==false && AddresC.getText().trim().isEmpty()==false && AgeC.getText().trim().isEmpty()==false) {
			SessionFactory factory=new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Client.class)
					.addAnnotatedClass(Reservation.class)
					.addAnnotatedClass(Room.class)
					.addAnnotatedClass(TypePaket.class)
					.addAnnotatedClass(Hotelservice.class)
					.buildSessionFactory();

		
			
		Session session=factory.getCurrentSession();

		try {
		

		System.out.println("Creating new Client..");
		
		
		session.beginTransaction();
		
				List<TypePaket> theTypePaket = session.createQuery("from TypePaket").getResultList();

				theTypePaket = session.createQuery("from TypePaket s where typepaket =" + "'" + hotelRoomType + "'").getResultList();
				TypePaket ChosenTypePaket = theTypePaket.get(0);
		
				List<Room> theChosenRoom = session.createQuery("from Room").getResultList();

				theChosenRoom  = session.createQuery("from Room s where roomnumber =" + "'" + hotelRoomNumber + "'").getResultList();
				Room Chosenroom = theChosenRoom.get(0);
				
				List<Hotelservice> theHotelservice = session.createQuery("from Hotelservice").getResultList();

				theHotelservice = session.createQuery("from Hotelservice s where typeservice =" + "'" + hotelServiceType + "'").getResultList();
				Hotelservice ChosenHotelservice = theHotelservice.get(0);
		
		
		
		Client CreateClient=new Client(userC,famalyC,addresC,phoneC,ageC,0,1);
		
		session.save(CreateClient);
		session.getTransaction().commit();
		
	
		Session session6 = factory.openSession();
		
		session6.getTransaction().begin();
		
		Reservation CreateReservation=new Reservation(datebegin,dateend,CreateClient.getId_client(),ChosenHotelservice.getId_service(),ChosenTypePaket.getId_typepaket(),83);
		System.out.println("Saving new Client..");
		
		session6.save(CreateReservation);
		session6.getTransaction().commit();
		System.out.println("Done!!!");
		
		

		}

		finally {
			
		factory.close();
		}
		}
		else
		{
		 System.out.println("Erro");
		}
		}
	
	public void cancel (ActionEvent actionEvent) {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		   stage.close();
		    
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Room.class)
				.addAnnotatedClass(TypePaket.class)
				.addAnnotatedClass(Hotelservice.class)
				.buildSessionFactory();

	Session session=factory.getCurrentSession();
	//saving
	try {
		session.beginTransaction();
		
		List<Room> theRooms=session.createQuery("from Room").getResultList();
		
		theRooms=session.createQuery("from Room ").getResultList();	
	    Room roomnumber=new Room();
	   
		for (int i=0; i<theRooms.size();i++) {
			roomnumber = theRooms.get(i);
		
		comboboxRoomNumber.getItems().add(roomnumber.getRoomnumber());
		
		System.out.println(roomnumber.getRoomnumber());

			
		
		}
			List<TypePaket> thePaket = session.createQuery("from TypePaket").getResultList();

			thePaket = session.createQuery("from TypePaket ").getResultList();
			TypePaket roomType = new TypePaket();
		
		for (int i=0; i<thePaket.size();i++) {
			roomType = thePaket.get(i);
		
			comboboxRoomType.getItems().add(roomType.getTypepaket());
		
		System.out.println(roomType.getTypepaket());

			
		
		}
		
			List<Hotelservice> theService = session.createQuery("from Hotelservice").getResultList();

			thePaket = session.createQuery("from Hotelservice ").getResultList();
			Hotelservice Service = new Hotelservice();

			for (int i = 0; i < theService.size(); i++) {
				Service = theService.get(i);

				comboboxServiceType.getItems().add(Service.getTypeservice());

				System.out.println(Service.getTypeservice());

			}
			
		session.getTransaction().commit();
	}
		finally {
		factory.close();
		}
		
	}
	
}
