package Questions.Sorting.question215;

import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int num : nums){
            priorityQueue.add(num);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }
    public static void main(String[] argv){
        // Creating an empty PriorityQueue
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        // Use add() method to add elements into the Queue
        queue.add(10);
        queue.add(15);
        queue.add(30);
        queue.add(20);
        queue.add(5);

        // Displaying the PriorityQueue
        System.out.println("Initial PriorityQueue: " + queue);

        // Fetching the element at the head of the queue
        System.out.println("The element at the head of the"
                + " queue is: " + queue.peek());

        // Displaying the Queue after the Operation
        System.out.println("Final PriorityQueue: " + queue);

        queue.poll();
        queue.poll();
        System.out.println(queue.peek());
        queue.add(10);
        System.out.println(queue.peek());

    }
}
