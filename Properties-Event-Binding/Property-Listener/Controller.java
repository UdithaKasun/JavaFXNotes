package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable{
	
		//These are reference to the Controllers mentioned FXML file
		@FXML
		private Button btnSubmit;
		@FXML
		private TextField txtName;
		@FXML
		private Label lblOld;
		@FXML
		private Label lblNew;
		
		private static double num = 0;
		final MyNumber myNum = new MyNumber();
		// This action is Performed when btnSubmit actionPerformed()
		public void getOutput(){
			myNum.setNumber(++num);
		}


		@Override
		public void initialize(URL location, ResourceBundle resources) {
			myNum.setNumber(0);
			
			//If the Value of myNumber Changes the value of lblOld will be changed
			//Value of lblNew also will change
			//addListner implements ChangeListner Interface
			
			myNum.number.addListener(new ChangeListener<Object>() {
				@Override
				public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
					System.out.println(observable);
					lblOld.setText(oldValue.toString());
					lblNew.setText(newValue.toString());
				}
			});
			
			//If the value of txtName change it will check for digits
			//If digits are contained it will output error
			
			txtName.textProperty().addListener((observable,oldValue,newValue) -> {
				boolean status;
				status = newValue.chars().anyMatch( e-> {
					return (Character.isDigit(e)) ;
				});
				if(!status){
					System.out.println("Input Correct");
				}
				else{
					System.out.println("Input Incorrect");
				}
			});
		}
	
}
