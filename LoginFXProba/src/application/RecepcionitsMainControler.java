package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RecepcionitsMainControler {
	@FXML
	private Button closeButton;
	@FXML
	private Button CreateClientForm;
	@FXML
	private Button CreateReservationForm;
	@FXML
	private Button GetReferenceForm;
	
public void CreateClientForm() throws Exception {
		
	Stage primaryStage=new Stage();
	Parent root = FXMLLoader.load(getClass().getResource("/application/createclient.fxml"));
	Scene scene = new Scene(root,350,335);
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.show();
	
	
}

public void CreateReservationForm() throws Exception {
	Stage primaryStage=new Stage();
	Parent root = FXMLLoader.load(getClass().getResource("/application/createReservation.fxml"));
	Scene scene = new Scene(root,340,400);
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.show();
	
}

public void GetReferenceForm() throws Exception {
	Stage primaryStage=new Stage();
	Parent root = FXMLLoader.load(getClass().getResource("/application/ReceptionistGetReference.fxml"));
	Scene scene = new Scene(root,500,460);
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.show();	

}

public void cancel (ActionEvent actionEvent) {
	Stage stage = (Stage) closeButton.getScene().getWindow();
	   stage.close();
	    
}

}
