package Questions.DynamicProgramming.question650;

public class MinSteps {
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        for (int number = 2; number <= n; number++) {
            dp[number] = number;
            for (int factor = 1; factor < n; factor++) {
                if (number % factor == 0) {
                    dp[number] = Math.min(dp[number],dp[number / factor] + factor);
                }
            }
        }
        return dp[n];
    }
}
