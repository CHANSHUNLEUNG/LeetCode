package Questions.DynamicProgramming.question377;

import java.util.Arrays;

public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int index = 0; index <= target; index++) {
            for (int num : nums) {
                if (index >= num) {
                    dp[index] = dp[index] + dp[index - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] argv) {
        System.out.println(new CombinationSum4().combinationSum4(new int[]{3, 1, 2, 4}, 4));
    }
}
