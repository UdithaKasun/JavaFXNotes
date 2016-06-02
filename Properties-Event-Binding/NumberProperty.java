//MyNumber class Contains a DoubleProperty
package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class MyNumber {
	public DoubleProperty number;

	public final double getNumber() {
		if (number != null)
			return number.get();
		return 0;
	}

	public final void setNumber(double number) {
		this.numberProperty().set(number);
	}
	
	private final DoubleProperty numberProperty(){
		if(number == null){
			number = new SimpleDoubleProperty(0);
		}
		
		return number;
	}
	
}
