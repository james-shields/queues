public class Test2 {
 
  public static void main(String[] args) {
   
    RandomizedQueue<String> q = new RandomizedQueue<String>();
    
    q.enqueue("a");
    q.enqueue("b");
    q.enqueue("c");
    System.out.println(q.toString());
    
    System.out.println(q.size());
    System.out.println(q.sample());
    
    System.out.println(q.dequeue());
    
    System.out.println(q.toString());
    System.out.println(q.size());
    
    q.enqueue("e");
    q.enqueue("d");
    q.enqueue("f");
    
    System.out.println(q.toString());
    
    System.out.println(q.isEmpty());
    
    System.out.println(q.size());
    
    for (String item : q) {
     System.out.println(item); 
    }
  }
  
}