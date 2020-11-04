package jianzhi.Question343;

public class IntegerBreak {
    public int integerBreak(int n) {
//        Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
//        dp[m] = dp[x] * dp[y] for x in 1, m-1
        int dp[] = new int[n+1];
        dp[2] = 1;
        for(int index=1; index<=n; index++){
            for(int j=1; j<index; j++){
                int current = Math.max(j * dp[index-j],j * (index-j));
                dp[index] = Math.max(dp[index], dp[j] * dp[index-j]);
            }
        }
        return dp[n];
    }
}
