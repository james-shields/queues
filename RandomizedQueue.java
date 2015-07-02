import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
 
  private Item[] queue;
  private int size;
  
  public RandomizedQueue() {
    
    queue = (Item[]) new Object[1];
    size = 0;
    
  }
  
  public boolean isEmpty() {
    return size == 0;
  }
  
  public int size() {
   return size; 
  }
  
  private int randomIndex() {
    return StdRandom.uniform(0, size);
  }
  
  private void resize(int capacity) {
    Item[] copy = (Item[]) new Object[capacity];
    for (int i = 0; i < size; i++) {
     copy[i] = queue[i]; 
    }
    queue = copy;
  }
  
  public void enqueue(Item item) {
    
    if (item == null) throw new NullPointerException("Item is null");
    
    if (size == queue.length) {
      resize(queue.length * 2);
    }

    queue[size++] = item;
    
  }
  
  public Item dequeue() {
    
    if (isEmpty()) throw new NoSuchElementException("Queue is empty");
    
    Item item;
    int index = randomIndex();
    
    item = queue[index];
    queue[index] = queue[size - 1];
    queue[size - 1] = null;
    size--;
    
    if(size > 0 && size == queue.length/4) resize(queue.length/2);
                         
    return item;
  }
  
  public Item sample() {
    
    if (isEmpty()) throw new NoSuchElementException("Queue is empty");
    
    return queue[randomIndex()];
  }
  
  public Iterator<Item> iterator() {
    return new RandomizedQueueIterator();
  }
  
  private class RandomizedQueueIterator implements Iterator {
    
    private int i;
    private int indices[];
    
    public RandomizedQueueIterator() {
     i = 0;
     indices = new int[size];
     for (int j = 0; j < size; j++) {
      indices[j] = j; 
     }
     StdRandom.shuffle(indices);

     
    }
    
    public boolean hasNext() {
     return i < size; 
    }
    
    public void remove() {
     throw new UnsupportedOperationException("Class does not support remove"); 
    }
    
    public Item next() { 
     
      if (i == size) throw new NoSuchElementException("No more items");
     
    
    return queue[indices[i++]];
     
    }
    
  }
  
  /*
  public String toString() {
   String s = "";
   
   for (int i = 0; i < size; i++) {
     s = s + " -> " + queue[i];
   }
   
   return s;
   
  }
  */
  
  
  public static void main(String[] args) {
    
  }
  
}