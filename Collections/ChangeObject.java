// This code will work with any of the previous ObservableList examples
observableList.addListener(new ListChangeListener() {
 
@Override
public void onChanged(ListChangeListener.Change change) {
    System.out.println("Detected a change! ");
    while (change.next()) {
        System.out.println("Was added? " + change.wasAdded());
        System.out.println("Was removed? " + change.wasRemoved());
        System.out.println("Was replaced? " + change.wasReplaced());
        System.out.println("Was permutated? " + change.wasPermutated());
        }
    }
});
