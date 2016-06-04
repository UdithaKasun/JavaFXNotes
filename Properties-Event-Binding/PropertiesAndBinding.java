package application;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;

public class PropertiesAndBinding {
	private static IntegerProperty num;
	
	public static void main(String[] args) {
		num = new SimpleIntegerProperty();
		bindAndUnBind();
	}
	
	//InvalidationListener 
	public static void addRemoveInvalidationListener() {
		final InvalidationListener listener = e -> System.out.println("Invalidated : " + e);
		
		System.out.println("Added Listener");
		num.addListener(listener);

		System.out.println("num.set(5)");
		num.set(5);
		
		System.out.println("num.set(5)");
		num.set(5);
		
		System.out.println("num.set(10)");
		num.set(10);
		
		System.out.println("num.removeListener(listener)");
		num.removeListener(listener);
		
		System.out.println("num.set(50)");
		num.set(50);
	}
	
	//ChangeListener
	public static void addRemoveChangeListener(){
		final ChangeListener<Object> listener = (observer, oldValue, newValue) -> System.out
				.println("Value Changed from : " + oldValue+ " to : " + newValue);
		
		System.out.println("Added Listener");
		num.addListener(listener);
		
		System.out.println("num.set(5)");
		num.set(5);
		
		System.out.println("num.set(5)");
		num.set(5);
		
		System.out.println("num.set(10)");
		num.set(10);
		
		System.out.println("num.removeListener(listener)");
		num.removeListener(listener);
		
		System.out.println("num.set(50)");
		num.set(50);
	}
	
	//Property Binding
	public static void bindAndUnBind(){
		IntegerProperty number = new SimpleIntegerProperty();
		number.bind(num);
		System.out.println("number is binded to num");
		
		System.out.println("num.set(10)");
		num.set(10);
		System.out.println("number : "+number.intValue());
		
		System.out.println("num.set(50)");
		num.set(50);
		System.out.println("number : "+number.intValue());
		
		number.unbind();
		System.out.println("number is unbinded now");
	
		System.out.println("num.set(100)");
		num.set(100);
		System.out.println("number : "+number.intValue());
	}
}
