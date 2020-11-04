package jianzhi.Question59;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Windows {
    //    给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
//    例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口
//    ，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
//    {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
//    {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
    public ArrayList<Integer> maxInWindows(int[] nums, int size) {
        ArrayList<Integer> answer = new ArrayList<>();
        if (nums == null ||size == 0|| nums.length == 0 || nums.length < size) {
            return answer;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y - x);
        int start = 0;
        for (int index = 0; index < nums.length; index++) {
            if (index < size) {
                priorityQueue.offer(nums[index]);
                continue;
            }
            answer.add(priorityQueue.peek());
            priorityQueue.remove(nums[start++]);
            priorityQueue.offer(nums[index]);
        }
        answer.add(priorityQueue.peek());

        return answer;
    }

    public int[] maxSlidingWindow(int[] nums, int k){
        if(nums == null){
            return new int[]{};
        }
        Deque<Integer> queue = new LinkedList<>();
        int[] answer = new int[nums.length-k+1];
        for(int index=0; index<nums.length; index++){
            if(!queue.isEmpty() && queue.peekFirst() <= index-k){
                queue.removeFirst();
            }

            while(!queue.isEmpty() && nums[queue.peekLast()] <nums[index]){
                queue.removeLast();
            }

            queue.addLast(index);
            if(index-k+1 >= 0){
                answer[index-k+1] = nums[queue.peekFirst()];
            }
        }
        return answer;
    }
}
