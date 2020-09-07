package Questions.DynamicProgramming.question518;

public class Change {
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (coins == null) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] += 1;
            }
            for (int subsum = coin; subsum <= amount; subsum++) {
                dp[subsum] = dp[subsum - coin] + dp[subsum];
            }
        }
        return dp[amount];
    }
}
