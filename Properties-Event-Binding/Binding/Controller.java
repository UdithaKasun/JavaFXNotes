package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;

public class Controller implements Initializable{
	
		//These are reference to the Controllers mentioned FXML file
		@FXML
		private Button btnInc;
		@FXML
		private Button btnDec;
		@FXML
		private ProgressBar pBar;
		@FXML
		private ProgressIndicator pIndicator;
		
		final MyNumber myNum = new MyNumber();
		
		public void incrementNumber(){
			myNum.setNumber(myNum.getNumber()+0.1);
		}
		
		public void decrementNumber(){
			myNum.setNumber(myNum.getNumber()-0.1);
		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			myNum.setNumber(0);	
			myNum.number.addListener((observe,oldVal,newVal) ->{
				
				//Binding myNum property with Progress Bar and Indicator
				
				pBar.progressProperty().bind(myNum.numberProperty());
				pIndicator.progressProperty().bind(myNum.numberProperty());
			});
		}
	
}
