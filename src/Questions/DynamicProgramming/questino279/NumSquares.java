package Questions.DynamicProgramming.questino279;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        int sqrt = (int) Math.sqrt(n);
        Arrays.fill(dp, Integer.MAX_VALUE);
        List<Integer> squares = new ArrayList<>();
        for (int index = 1; index <= sqrt; index++) {
            squares.add(index * index);
        }
        for (int number = 1; number <= n; number++) {

            for (int square : squares) {
                if (square > number) {
                    break;
                } else if (square == number) {
                    dp[number] = 1;
                    break;
                }
                dp[number] = Math.min(dp[number], dp[number - square] + 1);
            }
        }
        return dp[n];
    }

}
