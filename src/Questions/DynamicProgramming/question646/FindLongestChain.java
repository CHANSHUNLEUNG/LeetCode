package Questions.DynamicProgramming.question646;

import java.util.Arrays;
import java.util.Comparator;

public class FindLongestChain {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, (first, second) -> {
            return first[1] - second[1];
        });
        int dp[] = new int[pairs.length];
        int max = 0;
        for (int index = 0; index < pairs.length; index++) {
            dp[index] = 1;
            for (int compareIndex = 0; compareIndex < index; compareIndex++) {
                if (pairs[index][0] > pairs[compareIndex][1]) {
                    dp[index] = Math.max(dp[index], dp[compareIndex] + 1);
                }
            }
            max = Math.max(max, dp[index]);
        }
        return max;
    }
}
