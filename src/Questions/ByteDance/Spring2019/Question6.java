package Questions.ByteDance.Spring2019;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

// dp[m] = dp[m- n] + 1  zuixiao    n = 1,4,16,64
public class Question6 {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int number = scanner.nextInt();
        int target = 1024 - number;
        int[] dp = new int[1025];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int[] coins = new int[]{1, 4, 16, 64};
        for (int value = 0; value <= 1024; value++) {
            for (int coin : coins) {
                if (value - coin >= 0) {
                    dp[value] = Math.min(dp[value], dp[value - coin] + 1);
                }
            }
        }
        System.out.println(dp[target]);
    }
}
