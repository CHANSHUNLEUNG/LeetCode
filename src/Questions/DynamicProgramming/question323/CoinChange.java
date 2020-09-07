package Questions.DynamicProgramming.question323;

import java.util.LinkedList;
import java.util.Queue;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
            for (int subsum = coin; subsum <= amount; subsum++) {
                if (dp[subsum] == 0 && dp[subsum - coin] != 0) {
                    dp[subsum] = dp[subsum - coin] + 1;
                } else if (dp[subsum - coin] != 0) {
                    dp[subsum] = Math.min(dp[subsum], dp[subsum - coin] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String[] argv) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 13));
    }
}
