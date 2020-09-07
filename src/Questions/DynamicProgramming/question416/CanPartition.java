package Questions.DynamicProgramming.question416;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int halfSum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            List<Integer> temp = new ArrayList<>();
            for (int subSum = 0; subSum < dp.length; subSum++) {
                if (dp[subSum]) {
                    temp.add(subSum + num);
                    if (subSum + num == halfSum) {
                        return true;
                    }
                }
            }
            for (int subSum : temp) {
                dp[subSum] = true;
            }
        }
        return false;
    }
}
