[ Synchronized Methods ]

A synchronized method includes the synchronized keyword in its header. 

(1) Instance Methods

  public class ID{
  
    int counter = 0;
  
    public synchronized int getID(){
      return counter++;
    }
  
  }

Lock is associated with the object on which method is called.

  ID id = new ID();
  System.out.println(id.getID());

The lock is associated with the ID object whose reference is stored in id. 

If another thread called id.getID() while this method was executing, the other thread would have
to wait until the executing thread released the lock.



