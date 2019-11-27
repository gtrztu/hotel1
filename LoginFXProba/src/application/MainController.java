package application;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hotel.entity.Hotel;
import login.entity.Login;
import client.entity.Client;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javafx.application.Platform;
import javafx.collections.FXCollections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
private ComboBox<String> ComboBoxM;
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


public void createNewOwner() {
	String user=uName.getText();
	String famaly=uFamaly.getText();
	String password=uPass.getText();
	String chekpassword=ChekuPass.getText();
	String username=uUserName.getText();
	int hotel=0;
	if(hotelid.getText().trim().isEmpty()==false)
	hotel=Integer.parseInt(hotelid.getText());
	
	
	if(password.equals(chekpassword) && uUserName.getText().trim().isEmpty()==false && uName.getText().trim().isEmpty()==false && uFamaly.getText().trim().isEmpty()==false && uPass.getText().trim().isEmpty()==false && ChekuPass.getText().trim().isEmpty()==false) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Login.class)
				.buildSessionFactory();


	Session session=factory.getCurrentSession();
	//saving
	try {
	System.out.println("Creating new Owner..");
	Login OwnerLogin=new Login(user,famaly,password,2,hotel,username);
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
   
	//for (int i=0; i<theHotels.size();i++) {
	//hotel = theHotels.get(i);
	
	//ChoiseBox1.getItems().add("Choice 1");
	//System.out.println(hotel.getName());

	
	
	//session.getTransaction().commit();
//	}
}
	finally {
	factory.close();
	}

	}




public void createManager() {
	String userM=uNameM.getText();
	String famalyM=uFamalyM.getText();
	String passwordM=uPassM.getText();
	String chekpasswordM=ChekuPassM.getText();
//	int hotelM=Integer.parseInt(hotelidM.getText());
	String usernameM=uUserNameM.getText();
	
	
	if(passwordM.equals(chekpasswordM) && uUserNameM.getText().trim().isEmpty()==false && uNameM.getText().trim().isEmpty()==false && uFamalyM.getText().trim().isEmpty()==false && uPassM.getText().trim().isEmpty()==false && ChekuPassM.getText().trim().isEmpty()==false) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Login.class)
				.buildSessionFactory();

	Session session=factory.getCurrentSession();
	//saving
	try {
	
		
	
	System.out.println("Creating new Owner..");
	Login ManagerLogin=new Login(userM,famalyM,passwordM,3,1,usernameM);
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




public void createClient() {
	String userC=uNameC.getText();
	String famalyC=uFamalyC.getText();
	String phoneC=PhoneC.getText();
	String addresC=AddresC.getText();
	int ageC=0;
	if(AgeC.getText().trim().isEmpty()==false)
	ageC=Integer.parseInt(AgeC.getText());


	
	
	if(uNameC.getText().trim().isEmpty()==false && uFamalyC.getText().trim().isEmpty()==false && PhoneC.getText().trim().isEmpty()==false && AddresC.getText().trim().isEmpty()==false && AgeC.getText().trim().isEmpty()==false) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Client.class)
				.buildSessionFactory();

	Session session=factory.getCurrentSession();
	//saving
	try {
	
		
	
	System.out.println("Creating new Client..");
	Client CreateClient=new Client(userC,famalyC,addresC,phoneC,ageC,0,1);
	session.beginTransaction();
	System.out.println("Saving new Client..");
	session.save(CreateClient);

	session.getTransaction().commit();
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








}

















