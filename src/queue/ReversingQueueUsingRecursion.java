package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReversingQueueUsingRecursion {


    public static Queue<Integer> reverse(Queue<Integer> queue){

    if(queue.isEmpty()){
        System.out.println("Queue is empty");
        return queue;
    }

    //removes first element
    int front = queue.poll();

    queue = reverse(queue);

    queue.offer(front);

    return queue;
    }


    public static void main(String[] args) {

        System.out.println("Before reversing a queue");
        Queue<Integer> queue = new LinkedList<>();

        queue.add(2);
        queue.add(3);
        queue.add(10);
        queue.add(144);
        queue.add(142);

        System.out.println(queue);


        System.out.println("After reversing a queue");
        Queue<Integer> reverse = reverse(queue);
        System.out.println(reverse);

    }
}
