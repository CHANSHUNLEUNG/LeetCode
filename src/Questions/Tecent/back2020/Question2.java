package Questions.Tecent.back2020;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Question2 {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int count = scanner.nextInt();
        int[] nums = new int[count];
        for (int index = 0; index < count; index++) {
            nums[index] = scanner.nextInt();
        }
        solve(nums);

    }

    private static void solve(int[] nums) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        int answer[] = new int[nums.length];
        for(int index=0; index<nums.length; index++){
            answer[index] += leftStack.size();
            while(!leftStack.isEmpty() && nums[index] >= leftStack.peek()){
                leftStack.pop();
            }
            leftStack.push(nums[index]);
        }
        for(int index=nums.length-1; index>=0; index--){
            answer[index] += rightStack.size();
            while(!rightStack.isEmpty() && nums[index] >= rightStack.peek()){
                rightStack.pop();
            }
            rightStack.push(nums[index]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int index=0; index<nums.length; index++){
            stringBuilder.append(1+answer[index] + " ");
        }
        System.out.println(stringBuilder.toString().substring(0,stringBuilder.length()-1));
    }
}
