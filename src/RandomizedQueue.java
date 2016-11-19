/**
 * Created by sole on 11/11/16.
 */
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] s;
    private int N = 0;
    // construct an empty randomized queue
    public RandomizedQueue(){
        s = (Item[]) new Object[2];
    }
    // is the queue empty?
    public boolean isEmpty(){
        return N == 0;
    }
    // return the number of items on the queue
    public int size() {
        return N;
    }
    // add the item
    public void enqueue(Item item){
        if (N == s.length){
            Item[] old_s = s;
            s = (Item[]) new Object[N * 2];
            for (int i = 0; i < N; i++) {
                s[i] = old_s[i];
            }
        }
        s[N++] = item;
    }
    // remove and return a random item
    public Item dequeue() {
        if (N == s.length/4){
            Item[] s_old = s;
            s = (Item[]) new Object[N/2];
            for (int i = 0; i < N; i++){
                s[i] = s_old[i];
            }
        }
        Item filler_item = s[--N];
        int item_index = StdRandom.uniform(0,N);
        Item item = s[item_index];
        s[item_index] = filler_item;
        return item;
    }
    // return (but do not remove) a random item
    public Item sample(){
        int index = StdRandom.uniform(0, N);
        return s[index];
    }
    private class RandomizedQueueIterator implements Iterator<Item>{
        private int count = 0;
        private Item[] temp;

        public RandomizedQueueIterator(){
            temp = (Item[]) new Object[N];
            for (int i = 0; i < N; i++){
                temp[i] = s[i];
            }
            StdRandom.shuffle(temp);
        }

        public boolean hasNext(){
            return count < N;
        }
        public Item next(){
            Item item = temp[count];
            count++;
            return item;
        }
    }
    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new RandomizedQueueIterator();
    }
    // unit testing
    public static void main(String[] args){
        int moo = StdRandom.uniform(0,1);
        System.out.println(moo);
    }
}
