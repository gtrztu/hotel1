package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GetReferenceControler {
	@FXML
	private Button closeButton;
	
	
	public void cancel (ActionEvent actionEvent) {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		   stage.close();
		    
	}
}

