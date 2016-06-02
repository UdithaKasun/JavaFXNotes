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
 







