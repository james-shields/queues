
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item> {
  
  //private class
  private class Node {
   Item item;
   Node next, previous;
  }
   
  //values
  private int count;
  private Node head;
  private Node tail;
  
  public Deque() {
    
    //initialize
    count = 0;
    head = new Node();
    tail = new Node();
      
    //set head and tail references to each other
    head.next = tail;
    tail.previous = head;
    
  }
  
  public boolean isEmpty() {
    
    return count == 0;
    
  }
  
  public int size() {
    return count;
  }
  
  public void addFirst(Item item) {
    
    if (item == null) throw new NullPointerException("Null object cannot be added to deque");
    
    //new node 
    Node newFirst = new Node();
    
    newFirst.item = item;
    newFirst.next = head.next;
    newFirst.previous = head;
    head.next = newFirst;
    newFirst.next.previous = newFirst;
    
    count++;   
  }
  
  public void addLast(Item item) {
    
    if (item == null) throw new NullPointerException("Null object cannot be added to deque");
    
    //new node 
    Node newLast = new Node();
    
    newLast.item = item;
    newLast.next = tail;
    newLast.previous = tail.previous;
    tail.previous = newLast;
    newLast.previous.next = newLast;
    
    count++;   
  }
  
  public Item removeFirst() {
    
    if (isEmpty()) throw new NoSuchElementException("Deque is empty");
    
    Node oldFirst = head.next;
    Node newFirst = oldFirst.next;
    
    Item item = oldFirst.item;
    
    //update links
    newFirst.previous = head;
    head.next = newFirst;
    
    count--;
    return item;
    
  }
  
  public Item removeLast() {
    
    
    if (isEmpty()) throw new NoSuchElementException("Deque is empty");
    
    Node oldLast = tail.previous;
    Node newLast = oldLast.previous;
    
    Item item = oldLast.item;
     
    newLast.next = tail;
    tail.previous = newLast;

    
    count--;
    return item;
  }
  
  /*
  public String toString() {
   
    Node current;
    String s;
    s = "";
    current = head.next;
    
    System.out.println("First: "+ head.next.item);
    System.out.println("Last: " + tail.previous.item);
    
    while (current != tail) {
      s = s + current.item + " -> ";
      current = current.next;
    }
    
    return s;
    
  }
  */
  
  public Iterator<Item> iterator() {
   return new DequeIterator(); 
  }
  
  private class DequeIterator implements Iterator<Item> {
    
      private Node current = head.next;
      
      public boolean hasNext() {
       return current != tail; 
      }
      
      public void remove() {
        throw new UnsupportedOperationException("remove() is not implemented");
      }
      
      public Item next() {
        
        if (current == tail) throw new NoSuchElementException("No more items in deque");
        
       Item item = current.item;
       current = current.next;
       return item;
       
      }
      
    }
  
    
 }
 
  
