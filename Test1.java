public class Test1 {
  
  public static void main(String[] args) {
    Deque<String> d = new Deque<String>();
    
    System.out.println(d.size());
    d.addFirst("Hello");
    
    d.addLast("world");
    System.out.println(d.size());
    System.out.println(d.removeLast());
    System.out.println(d.removeFirst());
    
    d.addFirst("you");
    d.addFirst("are");
    
    System.out.println(d.removeFirst());
    System.out.println(d.removeLast());
    System.out.println(d.size());
    
    d.addFirst("a");
    d.addLast("b");
    d.addFirst("c");
    d.addLast("d");
    
    for (String item : d) {
      System.out.println(item);
      for (String item2 : d) {
        System.out.println(item2);
      }
    }
  }
  
}