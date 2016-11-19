import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

public class Subset {
    public static void main(String[] args){
        String input;
        RandomizedQueue<String> randQueue = new RandomizedQueue<String>();
        Integer k = Integer.parseInt(args[0]);
        for (int i = 0; i < k; i++){
            input = StdIn.readString();
            randQueue.enqueue(input);
        }
        Iterator<String> iter = randQueue.iterator();
        while (iter.hasNext()){
            String res = iter.next();
            System.out.println(res);
        }
    }
}
