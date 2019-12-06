package application;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hotel.entity.Hotel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OwnerControler  {
	
	@FXML
	private Button closeButton;
	

	
	public void FormcreateNewMeneger() throws Exception {
		
		Stage primaryStage=new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/OwnerCreateManager.fxml"));
		Scene scene = new Scene(root,290,412);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);

		primaryStage.show();
		
	}
		
		

	public void cancel (ActionEvent actionEvent) {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		   stage.close();
		    
	}


}
