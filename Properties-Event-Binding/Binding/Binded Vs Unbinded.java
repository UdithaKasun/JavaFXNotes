<-- Not Binded Way -->

public class Binding {
	public static void main(String[] args) {
		int x = 5;
		int y = 5;
		
		int sum = x+y;
		
		System.out.println("Sum Before : "+sum);
		
		x = 10;
		
		System.err.println("Sum After : "+sum);
	}
}

<-- Output -->

Sum Before : 10
Sum After : 10

*** Even though the value of x is changed to 10 and the sum should be 15. 
sum variables does not get notified about a change, so it prints the old value.

<-- Binded Way -->

package application;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Binding {
	public static void main(String[] args) {
		
		IntegerProperty num1 = new SimpleIntegerProperty(5);
		IntegerProperty num2 = new SimpleIntegerProperty(5);

		NumberBinding sum = num1.add(num2);
		
		System.out.println("Sum Before : "+sum.doubleValue());
		
		num1.set(10);
		
		System.err.println("Sum After : "+sum.doubleValue());
		
	}
}

<-- Output -->

Sum Before : 10.0
Sum After : 15.0


