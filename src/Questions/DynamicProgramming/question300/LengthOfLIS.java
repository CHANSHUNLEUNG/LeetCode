package Questions.DynamicProgramming.question300;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int max = 0;
        for (int index = 0; index < nums.length; index++) {
            dp[index] = 1;
            for (int backIndex = 0; backIndex < index; backIndex++) {
                if (nums[index] > nums[backIndex]) {
                    dp[index] = Math.max(dp[index], dp[backIndex] + 1);
                }
            }
            max = Math.max(max, dp[index]);
        }
        return max;
    }

    public static void main(String[] argv) {
    }
}
