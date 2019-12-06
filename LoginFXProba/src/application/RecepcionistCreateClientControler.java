package application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import client.entity.Client;
import hotelservice.entity.Hotelservice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import reservation.entity.Reservation;
import room.entity.Room;
import typepaket.entity.TypePaket;

public class RecepcionistCreateClientControler {
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
	private Label lblStatus;

	
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

			try {
			

			System.out.println("Creating new Client..");
			
			
			session.beginTransaction();
			
			Client CreateClient=new Client(userC,famalyC,addresC,phoneC,ageC,0,MainController.hotelid);

			
			session.save(CreateClient);
			session.getTransaction().commit();
			lblStatus.setText("Status:Success");
			}

			finally {
				
			factory.close();
			}
			}
			else
			{
				lblStatus.setText("Status:Something whent wrong");
			}
		
		
	}
	
	
	public void cancel (ActionEvent actionEvent) {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		   stage.close();
		    
	}
}
