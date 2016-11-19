import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by sole on 11/11/16.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int size;
    private class Node {
        private Item item;
        private Node next, prev;
    }

    public Deque(){
        first = null;
        last = null;
        size = 0;
    }
    public boolean isEmpty() {                 // is the deque empty?
        return first == null;
    }
    public int size(){
        return this.size;
    }
    // add the item to the front
    public void addFirst(Item item){
        if (item == null)
            throw new NullPointerException();
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        if (oldFirst == null){
            last = first;
        }else{
            oldFirst.prev = first;
        }
        first.next = oldFirst;


        size++;
    }

    // add the item to the end
    public void addLast(Item item){
        if (item == null)
            throw new NullPointerException();
        if (!isEmpty()){
            Node oldLast = last;
            last = new Node();
            last.item = item;
            oldLast.next = last;
            last.prev = oldLast;
        }else{
               first = new Node();
               last = first;
               last.item = item;
        }
        size++;
    }
    // remove and return the item from the front
    public Item removeFirst(){
        if (this.size == 0){
            throw new NoSuchElementException();
        }
        Item item = first.item;
        first = first.next;
        if (isEmpty()){
            last = null;
        }
        size--;
        return item;
    }
    // remove and return the item from the end
    public Item removeLast(){
        if (this.size == 0){
            throw new NoSuchElementException();
        }
        Item item =  last.item;
        last = last.prev;
        if (last == null){
            first = null;
        }
        size--;
        if (size == 0){
            first = null;
        }
        return item;
    }
    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext() {return current != null;}
        public Item next(){
            if (!this.hasNext()){
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    // return an iterator over items in order from front to end
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
//    private static void addLastRemoveLastTest(){
//        Deque<Integer> dq = new <Integer>Deque();
//        dq.addLast(3);
//        dq.addLast(2);
//        dq.addLast(1);
//
//        Integer last = dq.removeLast();
//        last = dq.removeLast();
//        last = dq.removeLast();
//        String result = "addLast removeLast test: ";
//        result += last == 3 ? "OK" : "FAIL";
//        System.out.println(result);
//    }
//
//    private static void addFirstRemoveFirstTest(){
//        Deque<Integer> dq = new <Integer>Deque();
//        dq.addFirst(3);
//        dq.addFirst(2);
//        dq.addFirst(1);
//
//        Integer last = dq.removeFirst();
//        last = dq.removeFirst();
//        last = dq.removeFirst();
//        String result = "addFirst removeFirst test: ";
//        result += last == 3 ? "OK" : "FAIL";
//        System.out.println(result);
//    }
//    private static void testSize(){
//        int fails = 0;
//        Deque<Integer> dq = new <Integer>Deque();
//        fails += dq.size() != 0 ? 1 : 0;
//
//        dq.addFirst(3);
//        fails += dq.size() != 1 ? 1 : 0;
//
//        dq.addFirst(2);
//        fails += dq.size() != 2 ? 1 : 0;
//
//        dq.addFirst(1);
//        fails += dq.size() != 3 ? 1 : 0;
//
//
//        Integer last = dq.removeFirst();
//        fails += dq.size() != 2 ? 1 : 0;
//
//        last = dq.removeFirst();
//        fails += dq.size() != 1 ? 1 : 0;
//
//        last = dq.removeFirst();
//        fails += dq.size() != 0 ? 1 : 0;
//
//        String result = "size test: ";
//        result += fails == 0 ? "OK" : "FAIL";
//        System.out.println(result);
//    }
    // unit testing
    public static void main(String[] args){
//        Deque.addLastRemoveLastTest();
//        Deque.addFirstRemoveFirstTest();
//        Deque.testSize();
    }

}