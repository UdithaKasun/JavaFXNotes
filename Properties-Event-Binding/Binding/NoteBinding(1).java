<-- Overview -->

JavaFX properties are often used in conjunction with binding, a powerful mechanism for expressing direct relationships between variables.
When objects participate in bindings, changes made to one object will automatically be reflected in another object.


The binding APIs are divided into two broad categories:

(1) The High-Level API: Provides a simple way to create bindings for the most common use cases. Its syntax is easy to learn and use, 		 	especially in environments that provide code completion, such as the NetBeans IDE.

(2)	The Low-Level API: Provides additional flexibility, and can be used by advanced developers in situations where the High-Level API is 	insufficient. The Low-Level API was designed for fast execution and small memory footprint.

<-- JavaFX Properties -->

(1) Defining a Property -> DoubleProperty amountDue

class Bill {
 
    // Define a variable to store the property
    private DoubleProperty amountDue = new SimpleDoubleProperty();
 
    // Define a getter for the property's value
    public final double getAmountDue(){return amountDue.get();}
 
    // Define a setter for the property's value
    public final void setAmountDue(double value){amountDue.set(value);}
 
     // Define a getter for the property itself
    public DoubleProperty amountDueProperty() {return amountDue;}
 
}

(2) Using a ChangeListener

public class Main {
 
    public static void main(String[] args) {
 
      Bill electricBill = new Bill();
 
       electricBill.amountDueProperty().addListener(new ChangeListener(){
        @Override public void changed(ObservableValue o,Object oldVal, 
                 Object newVal){
             System.out.println("Electric bill has changed!");
        }
      });
     
      electricBill.setAmountDue(100.00);
     
    }
}

*** Running this example will print the message "Electric bill has changed" to standard output, proving that the change listener 		 		notification is working.

*** addListener method is availble in all JavaFX Properties.

 someProperty.addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
			}
 );


<-- ChangeListener -->

(1) A ChangeListener can be attached to any ObservableValue (e.g. JavaFX Properties) and it gets notified, if the value of the           ObservableValue changes. 

(2) An obvious advantage is, that old and new value are provided automatically in the method handler. But this advantage is rather       minor and can be neglected.  

(3) A more important advantage is, that a ChangeListener only gets fired, if the value REALLY changes. (InvalidationListener do not guarantee this, as we will see in a minute.) 

(4) The disadvantage of a ChangeListener is, that it enforces eager calculation of bindings. Because we want to notify a ChangeListener only, if the value really changed, we have to calculate the new result of a binding immediately.

<-- InvalidationListener -->

(1) InvalidationListener can be attached to any Observable (e.g. any ObservableValue is an Observable). 

(2) It is notified when the Observable may have changed – there is no guarantee, that it really changed. 

(3) The main advantage is, that the runtime does not have to compare old value and new value. 

(4) In other words, bindings can still be calculated lazily, if an InvalidationListener is attached. The disadvantage is, that it may fire if the value did not really change.








