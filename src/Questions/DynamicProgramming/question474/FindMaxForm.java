package Questions.DynamicProgramming.question474;

public class FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeros = 0, ones = 0;
            for (char character : str.toCharArray()) {
                if (character == '1') {
                    ones++;
                } else {
                    zeros++;
                }
            }
            for (int zero = m; zero >= zeros; zero--) {
                for (int one = n; one >= ones; one--) {
                    dp[zero][one] = Math.max(dp[zero][one], dp[zero - zeros][one - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
