package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hotel.entity.Hotel;
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

public class AdministratorControler implements Initializable {

	@FXML
	private TextField uPass;
	@FXML
	private TextField ChekuPass;
	@FXML
	private TextField uFamaly;
	@FXML
	private TextField uName;
	@FXML
	private TextField uUserName;
	@FXML
	private TextField hotelid;
	@FXML
	private Label lblChekPasword;
	@FXML
	private Button closeButton;
	@FXML
	private ComboBox<String> comboboxAdmin;

	
	
	public void createNewOwner() {
		String user=uName.getText();
		String famaly=uFamaly.getText();
		String password=uPass.getText();
		String chekpassword=ChekuPass.getText();
		String username=uUserName.getText();
		String hotelid=comboboxAdmin.getValue();
		
		if(password.equals(chekpassword) && uUserName.getText().trim().isEmpty()==false && uName.getText().trim().isEmpty()==false && uFamaly.getText().trim().isEmpty()==false && uPass.getText().trim().isEmpty()==false && ChekuPass.getText().trim().isEmpty()==false) {
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
		Login OwnerLogin=new Login(user,famaly,password,2,IDhotel.getId_hotel(),username);
		
		
		System.out.println("Saving new Owner..");
		session.save(OwnerLogin);

		session.getTransaction().commit();
		System.out.println("Done!!!");
		
		lblChekPasword.setText("Status:Owner created");
		

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
		
		comboboxAdmin.getItems().add(hotel.getName());
		
		System.out.println(hotel.getName());

			
		
		}
		session.getTransaction().commit();
	}
		finally {
		factory.close();
		}
		
	}
	
	
	
	
	
}
