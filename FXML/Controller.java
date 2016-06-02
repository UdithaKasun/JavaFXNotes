package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
	
		//These are reference to the Controllers mentioned FXML file
		@FXML
		private Button btnSubmit;
		@FXML
		private TextField txtName;
		@FXML
		private Label lblText;
		
		
		// This action is Performed when btnSubmit actionPerformed()
		public void getOutput(){
			System.out.println("Input : "+txtName.getText());
			lblText.setText(txtName.getText());
		}
	
}
