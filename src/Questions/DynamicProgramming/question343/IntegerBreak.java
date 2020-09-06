package Questions.DynamicProgramming.question343;

public class IntegerBreak {
    public int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int number = 3; number <= n; number++) {
            for (int complement = 1; complement < number; complement++) {
                dp[number] = Math.max(Math.max(complement, dp[complement]) * Math.max(number - complement, dp[number - complement]), dp[number]);
            }
        }
        return dp[n];
    }
}
