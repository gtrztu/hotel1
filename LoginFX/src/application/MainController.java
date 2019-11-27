package application;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hotel.entity.Hotel;
import login.entity.Login;
import recepcionist.entity.Recepcionist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {
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
@FXML
private TextField uPass;
@FXML
private TextField ChekuPass;
@FXML
private TextField uFamaly;
@FXML
private TextField uName;
@FXML
private TextField hotelid;
@FXML
private TextField uPassM;
@FXML
private TextField ChekuPassM;
@FXML
private TextField uFamalyM;
@FXML
private TextField uNameM;
@FXML
private TextField hotelidM;
@FXML
private TextField uPassRe;
@FXML
private TextField ChekuPassRe;
@FXML
private TextField uFamalyRe;
@FXML
private TextField uNameRe;
@FXML
private Label lblChekPasword;
@FXML
private ChoiceBox ChoiseBox1;

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
			String[] names=us.split("\\s+");
			List<Login> theHotels = session.createQuery("from Login").getResultList();		
			System.out.println(us);
			
			theHotels = session.createQuery("from Login s where Fname ="+"'"+names[0]+"'"+"and lname="+"'"+names[1]+"'"+"and passwordl="+"'"+password+"'").getResultList();
			
			Login log = theHotels.get(0);
		System.out.println(log.getId_log());
	

			session.getTransaction().commit();
		
	
	
	// javafX window for login if credentials are met 
			if(log.getNumber()==1) {
	//	if(names[0].equals(log.getFname()) && names[1].equals(log.getLname()) && txtpassword.getText().equals(log.getPassword())) {
		lblStatus.setText("Login Success");
		Stage primaryStage=new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/administrator.fxml"));
		Scene scene = new Scene(root,600,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//primaryStage.setOnCloseRequest(e -> Platform.exit());
	//	Stage primarystage = (Stage) LoginButton.getScene().getWindow();
	//	primarystage.close();

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
	}
	else {
		lblStatus.setText("Login Failed");
	}
		
		
			
		}
		finally {
			
			factory.close();
		}
	
}
public void cancel (ActionEvent actionEvent) {
	 Stage stage = (Stage) closeButton.getScene().getWindow();
	    stage.close();
}


public void createNewOwner() {
	String user=uName.getText();
	String famaly=uFamaly.getText();
	String password=uPass.getText();
	String chekpassword=ChekuPass.getText();
	int hotel=Integer.parseInt(hotelid.getText());
	
	
	if(password.equals(chekpassword)) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Login.class)
				.buildSessionFactory();


	Session session=factory.getCurrentSession();
	//saving
	try {
	System.out.println("Creating new Owner..");
	Login OwnerLogin=new Login(user,famaly,password,2,hotel);
	session.beginTransaction();
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


public void FormcreateNewReceptionist() throws Exception{
	Stage primaryStage=new Stage();
	Parent root = FXMLLoader.load(getClass().getResource("/application/ManagerCreateReceptionist.fxml"));
	Scene scene = new Scene(root,660,430);
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.show();
	
	

	}
public void FormcreateNewMeneger() throws Exception{
	Stage primaryStage=new Stage();
	Parent root = FXMLLoader.load(getClass().getResource("/application/OwnerCreateManager.fxml"));
	Scene scene = new Scene(root,300,360);
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.show();
	
	

	}




public void createManager() {
	String userM=uNameM.getText();
	String famalyM=uFamalyM.getText();
	String passwordM=uPassM.getText();
	String chekpasswordM=ChekuPassM.getText();
//	int hotelM=Integer.parseInt(hotelidM.getText());

	
	
	if(passwordM.equals(chekpasswordM)) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Login.class)
				.addAnnotatedClass(Hotel.class)
				.buildSessionFactory();

	Session session=factory.getCurrentSession();
	//saving
	try {
	//	session.beginTransaction();
		
		//List<Login> theHotels=session.createQuery("from Login").getResultList();
		
		//theHotels=session.createQuery("select name from Hotel join login on hotel.id_hotel=login.hotel_id_hotel").getResultList();	
		
	System.out.println("Creating new Owner..");
	Login ManagerLogin=new Login(userM,famalyM,passwordM,3,1);
	session.beginTransaction();
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



public void createRecepcionist() {
	String userRe=uNameRe.getText();
	String famalyRe=uFamalyRe.getText();
	String passwordRe=uPassRe.getText();
	String chekpasswordRe=ChekuPassRe.getText();

	
	if(passwordRe.equals(chekpasswordRe)) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Recepcionist.class)
				.buildSessionFactory();

	Session session=factory.getCurrentSession();
	//saving
	try {
	System.out.println("Creating new Owner..");
	Recepcionist RecepcionistLogin=new Recepcionist(userRe,famalyRe,passwordRe,1);
	session.beginTransaction();
	System.out.println("Saving new Owner..");
	session.save(RecepcionistLogin);

	session.getTransaction().commit();
	System.out.println("Done!!!");
	
	lblChekPasword.setText("Status:Recepcionist created");
	

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
}






