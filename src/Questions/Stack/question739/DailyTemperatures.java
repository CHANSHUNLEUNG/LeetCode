package Questions.Stack.question739;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] answer = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index < T.length; index++) {
            while (!stack.isEmpty() && T[index] > T[stack.peek()]) {
                int currentIndex = stack.pop();
                answer[currentIndex] = index - currentIndex;
            }
            stack.push(index);
        }
        return answer;
    }
}
