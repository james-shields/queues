
public class Subset {
  public static void main(String[] args) {
    
    RandomizedQueue<String> d = new RandomizedQueue<String>();
    int k = Integer.parseInt(args[0]);
    
    while (!StdIn.isEmpty()) {
      
      d.enqueue(StdIn.readString());
      
      
    }
    
    for (int i = 0; i < k; i++) {
     System.out.println(d.dequeue());
    }


  }
}
