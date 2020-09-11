package Questions.Stack.question503;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int[] answer = new int[nums.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index < nums.length * 2; index++) {
            int currentIndex = index % nums.length;
            while (!stack.isEmpty() && nums[currentIndex] > nums[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = nums[currentIndex];
            }
            if (index < nums.length) {
                stack.push(index);
            }
        }
        return answer;
    }
}
