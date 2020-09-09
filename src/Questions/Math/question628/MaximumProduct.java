package Questions.Math.question628;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumProduct {
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> priorityQueueSmall = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueueLarge = new PriorityQueue<>((x, y) -> y - x);
        for (int num : nums) {
            priorityQueueSmall.offer(num);
            priorityQueueLarge.offer(num);
        }
        int max1 = priorityQueueLarge.poll();
        int max2 = priorityQueueLarge.poll();
        int max3 = priorityQueueLarge.poll();
        int min1 = priorityQueueSmall.poll();
        int min2 = priorityQueueSmall.poll();
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
