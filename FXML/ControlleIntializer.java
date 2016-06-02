package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable{
	  
		 //To get initialize method you must implement Initializable Interface
	  
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

    		//This method runs after form loading is complete
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			System.out.println("Loading User Data");
		}
	
}
