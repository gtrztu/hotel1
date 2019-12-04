package application;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import login.entity.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController  {
	
	
	
@FXML
private Label lblStatus;

@FXML
private TextField txtusername;

@FXML
private TextField txtpassword;
@FXML
private Button closeButton;
@FXML
private Button LoginButton;





public void Login(ActionEvent Event) throws Exception {
	SessionFactory factory=new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Login.class)
			.buildSessionFactory();

Session session=factory.getCurrentSession();


		try {		
			String us=txtusername.getText();
			String password=txtpassword.getText();
			
			session.beginTransaction();

			List<Login> theHotels = session.createQuery("from Login").getResultList();		
			System.out.println(us);

			theHotels = session.createQuery("from Login s where username ="+"'"+us+"'"+"and passwordl="+"'"+password+"'").getResultList();
			
			Login log = theHotels.get(0);
			System.out.println(log.getId_log());
	

			session.getTransaction().commit();
		
	
			
	// javafX window for login if credentials are met 
			if(log.getNumber()==1) {
		lblStatus.setText("Login Success");
		Stage primaryStage=new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/administrator.fxml"));
		Scene scene = new Scene(root,600,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Stage stage = (Stage) LoginButton.getScene().getWindow();
		   stage.close();
	} 
	
	else if (log.getNumber()==2)
	{
		lblStatus.setText("Login Success");
		Stage primaryStage=new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Owner.fxml"));
		Scene scene = new Scene(root,475,460);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Stage stage = (Stage) LoginButton.getScene().getWindow();
		   stage.close();
	}
	else if (log.getNumber()==3)
	{
		
		lblStatus.setText("Login Success");
		Stage primaryStage=new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/ManagerMain.fxml"));
		Scene scene = new Scene(root,660,430);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Stage stage = (Stage) LoginButton.getScene().getWindow();
		   stage.close();
	}
	else if (log.getNumber()==4)
	{
		lblStatus.setText("Login Success");
		Stage primaryStage=new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/receptionist.fxml"));
		Scene scene = new Scene(root,625,470);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Stage stage = (Stage) LoginButton.getScene().getWindow();
		   stage.close();
	}
	else {
		lblStatus.setText("Login Failed");
	}
		
		
		}
		
		catch(Exception e){
			lblStatus.setText("Login Failed Try again");
			System.out.println("Error");
			factory.close();
		}
		finally {
			factory.close();
			}
	
}

public void cancel (ActionEvent actionEvent) {
	Stage stage = (Stage) closeButton.getScene().getWindow();
	   stage.close();
	    
}


}

















