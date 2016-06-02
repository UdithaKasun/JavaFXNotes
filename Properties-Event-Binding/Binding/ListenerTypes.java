<-- Exploring Observable, ObservableValue, InvalidationListener, and ChangeListener -->

(1) The Observable and ObservableValue interfaces fire the change notifications.

(2) The InvalidationListener and ChangeListener interfaces receive them.

(3)  ObservableValue wraps a value and fires its changes to any registered ChangeListener.

(4) Observable (which does not wrap a value) fires its changes to any registered InvalidationListener.

<-- InvalidationListner -->

package application;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Binding {
	public static void main(String[] args) {
		Bill b1 = new Bill();
		Bill b2 = new Bill();
		Bill b3 = new Bill();
		
		NumberBinding total = Bindings.add(b1.getAmountDueProperty().add(b1.getAmountDueProperty()),b3.getAmountDueProperty());
		
		total.addListener(listener -> System.out.println("Binding is now Invalid"));
		
		//Makes binding Invalid
		b1.setAmountDue(100);
		
		// The binding is now invalid so it will not bother about calculation of total
		b2.setAmountDue(200);
		b3.setAmountDue(300);
		
		//Binding is valid again and it will calculate value because it is needed
		System.out.println("Total : "+total.doubleValue());
		
		//Binding is Invalid again
		b1.setAmountDue(1000);
	}
}

*** All above bindings are High-level API Bindings.

<-- Low Level API Bindings -->

package bindingdemo;
 
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.binding.DoubleBinding;
 
public class Main {
 
    public static void main(String[] args) {
 
        final DoubleProperty a = new SimpleDoubleProperty(1);
        final DoubleProperty b = new SimpleDoubleProperty(2);
        final DoubleProperty c = new SimpleDoubleProperty(3);
        final DoubleProperty d = new SimpleDoubleProperty(4);
 
        DoubleBinding db = new DoubleBinding() {
 
            {
                super.bind(a, b, c, d);
            }
 
            @Override
            protected double computeValue() {
                return (a.get() * b.get()) + (c.get() * d.get());
            }
        };
 
        System.out.println(db.get());
        b.set(3);
        System.out.println(db.get());
    }
}

(1) Using the Low-Level API involves extending one of the binding classes and overriding its computeValue() method to return the        current value of the binding. 

(2) The invocation of super.bind() passes the dependencies up to DoubleBinding so that the default invalidation behavior is retained.   It is generally not necessary for you to check if the binding is invalid; this behavior is provided for you by the base class.
