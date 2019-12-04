package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hotel.entity.Hotel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import login.entity.Login;

public class OwnerCreateManager  implements Initializable {
	@FXML
	private TextField uPassM;
	@FXML
	private TextField ChekuPassM;
	@FXML
	private TextField uFamalyM;
	@FXML
	private TextField uNameM;
	@FXML
	private TextField uUserNameM;
	@FXML
	private Label lblChekPasword;
	@FXML
	private Button closeButton;
	@FXML
	private ComboBox<String> combobox1;
	ObservableList<String> list;
	
	public void createManager() {
		String userM=uNameM.getText();
		String famalyM=uFamalyM.getText();
		String passwordM=uPassM.getText();
		String chekpasswordM=ChekuPassM.getText();
		String hotelid=combobox1.getValue();
		String usernameM=uUserNameM.getText();
		
		
		if(passwordM.equals(chekpasswordM) && uUserNameM.getText().trim().isEmpty()==false && uNameM.getText().trim().isEmpty()==false && uFamalyM.getText().trim().isEmpty()==false && uPassM.getText().trim().isEmpty()==false && ChekuPassM.getText().trim().isEmpty()==false) {
			SessionFactory factory=new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Login.class)
					.addAnnotatedClass(Hotel.class)
					.buildSessionFactory();

		Session session=factory.getCurrentSession();
		//saving
		try {
		
			
		
		System.out.println("Creating new Owner..");
		
		session.beginTransaction();
		
		List<Hotel> theHotels = session.createQuery("from Hotel").getResultList();		
		

		theHotels = session.createQuery("from Hotel s where name ="+"'"+hotelid+"'").getResultList();
		Hotel IDhotel = theHotels.get(0);
		Login ManagerLogin=new Login(userM,famalyM,passwordM,3,IDhotel.getId_hotel(),usernameM);
		
		System.out.println("Saving new Owner..");
		session.save(ManagerLogin);

		session.getTransaction().commit();
		System.out.println("Done!!!");
	
		lblChekPasword.setText("Status:Manager created");
		

		}

		finally {
		factory.close();
		}
		}
		else
		{
		 lblChekPasword.setText("Status:Passwords dont match or empty fileds");
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
				.addAnnotatedClass(Hotel.class)
				.buildSessionFactory();

	Session session=factory.getCurrentSession();
	//saving
	try {
		session.beginTransaction();
		
		List<Hotel> theHotels=session.createQuery("from Hotel").getResultList();
		
		theHotels=session.createQuery("from Hotel ").getResultList();	
	    Hotel hotel=new Hotel();
	   
		for (int i=0; i<theHotels.size();i++) {
		hotel = theHotels.get(i);
		
		combobox1.getItems().add(hotel.getName());
		
		System.out.println(hotel.getName());

			
		
		}
		session.getTransaction().commit();
	}
		finally {
		factory.close();
		}

		}
	
	
		
	}
	

