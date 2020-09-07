package Questions.DynamicProgramming.question494;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = Arrays.stream(nums).sum();
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int targetSum = (S + sum) / 2;
        int[] dp = new int[targetSum + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int subsum = targetSum; subsum>=num; subsum--) {
                dp[subsum] = dp[subsum] + dp[subsum - num];
            }
        }
        return dp[targetSum];
    }

    public static void main(String[] argv) {
        System.out.println(new FindTargetSumWays().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
