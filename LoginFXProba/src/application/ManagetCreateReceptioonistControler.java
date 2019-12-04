package application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import login.entity.Login;

public class ManagetCreateReceptioonistControler {

	@FXML
	private TextField uPassRe;
	@FXML
	private TextField ChekuPassRe;
	@FXML
	private TextField uFamalyRe;
	@FXML
	private TextField uNameRe;
	@FXML
	private TextField uUserNameRe;
	@FXML
	private Label lblChekPasword;
	
	public void createRecepcionist() {
		String userRe=uNameRe.getText();
		String famalyRe=uFamalyRe.getText();
		String passwordRe=uPassRe.getText();
		String chekpasswordRe=ChekuPassRe.getText();
		String usernameRe=uUserNameRe.getText();
		
		if(passwordRe.equals(chekpasswordRe)) {
			SessionFactory factory=new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Login.class)
					.buildSessionFactory();

		Session session=factory.getCurrentSession();
		//saving
		try {
		System.out.println("Creating new Receptionist..");
		Login RecepcionistLogin=new Login(userRe,famalyRe,passwordRe,4,1,usernameRe);
		session.beginTransaction();
		System.out.println("Saving new Recepcionist..");
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
