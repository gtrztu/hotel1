package application;

import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import client.entity.Client;
import hotelservice.entity.Hotelservice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import reservation.entity.Reservation;
import room.entity.Room;
import typepaket.entity.TypePaket;

public class CreateReservationControler implements Initializable{
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
	@FXML
	private TextField PhoneC;
	
	public void createReservation() {
		String clientPhone = PhoneC.getText();
		String hotelRoomType = comboboxRoomType.getValue();

		int hotelRoomNumber = 0;
		if (comboboxRoomNumber.getValue().trim().isEmpty() == false)
			hotelRoomNumber = Integer.parseInt(comboboxRoomNumber.getValue());

		String hotelServiceType = comboboxServiceType.getValue();
		LocalDate datebegin = Datebegin.getValue();
		LocalDate dateend = Dateend.getValue();
		
		
		
	
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
		
		/*DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.of(2009, 9, 10);
        LocalDate date2 = LocalDate.of(2009, 4, 10);
		
		
			List<Hotelservice> theService = session.createQuery("from Hotelservice").getResultList();

			theService = session.createQuery("from Hotelservice ").getResultList();
			Hotelservice Service = new Hotelservice();

			//for (int i = 0; i < theService.size(); i++) {
				//Service = theService.get(i);
				
				if(datebeginService.getMonth().compareTo(date1.getMonth())>=0 && datebeginService.getMonth().compareTo(date2.getMonth())<=0) {
				Service = theService.get(1);
				comboboxServiceType.getItems().add(Service.getTypeservice());
				}
				else {
					Service = theService.get(0);
				comboboxServiceType.getItems().add(Service.getTypeservice());
				System.out.println(Service.getTypeservice());
				}
		*/
		
		
		
		
		
			List<Client> theClientPhone = session.createQuery("from Client").getResultList();

			theClientPhone = session.createQuery("from Client s where phone =" + "'" + clientPhone + "'").getResultList();
			Client ChosenClientId = theClientPhone.get(0);
		
		
				List<TypePaket> theTypePaket = session.createQuery("from TypePaket").getResultList();

				theTypePaket = session.createQuery("from TypePaket s where typepaket =" + "'" + hotelRoomType + "'").getResultList();
				TypePaket ChosenTypePaket = theTypePaket.get(0);
		
				List<Room> theChosenRoom = session.createQuery("from Room").getResultList();

				theChosenRoom  = session.createQuery("from Room s where roomnumber =" + "'" + hotelRoomNumber + "'").getResultList();
				Room Chosenroom = theChosenRoom.get(0);
				
				List<Hotelservice> theHotelservice = session.createQuery("from Hotelservice").getResultList();

				theHotelservice = session.createQuery("from Hotelservice s where typeservice =" + "'" + hotelServiceType + "'").getResultList();
				Hotelservice ChosenHotelservice = theHotelservice.get(0);
				
				Reservation CreateReservation=new Reservation(datebegin,dateend,ChosenClientId.getId_client(),ChosenHotelservice.getId_service(),ChosenTypePaket.getId_typepaket(),MainController.logid);
		
				session.save(CreateReservation);
				session.getTransaction().commit();
		}

		finally {
			
		factory.close();
		}
		
		
	}
	
	
	
	public void cancel (ActionEvent actionEvent) {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		   stage.close();
		    
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		LocalDate datebeginService = Datebegin.getValue();
		LocalDate dateendService = Dateend.getValue();
		
		
		
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
		if(roomnumber.getStatus()==true) {
		comboboxRoomNumber.getItems().add(roomnumber.getRoomnumber());
		}
		
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
		
		//DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      //  LocalDate date1 = LocalDate.of(2009, 9, 10);
       // LocalDate date2 = LocalDate.of(2009, 4, 10);
		
		
			List<Hotelservice> theService = session.createQuery("from Hotelservice").getResultList();

			theService = session.createQuery("from Hotelservice ").getResultList();
			Hotelservice Service = new Hotelservice();

			for (int i = 0; i < theService.size(); i++) {
				Service = theService.get(i);
			
				//if(datebeginService.getMonth().compareTo(date1.getMonth())>=0 && datebeginService.getMonth().compareTo(date2.getMonth())<=0) {
				//Service = theService.get(1);
				//comboboxServiceType.getItems().add(Service.getTypeservice());
				//}
				//else {
				//	Service = theService.get(0);
				comboboxServiceType.getItems().add(Service.getTypeservice());
				System.out.println(Service.getTypeservice());
				//}

			}
			
		session.getTransaction().commit();
	}
		finally {
		factory.close();
		}
		
	}
}
