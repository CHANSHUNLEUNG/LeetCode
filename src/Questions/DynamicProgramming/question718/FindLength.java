package Questions.DynamicProgramming.question718;

public class FindLength {
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null) {
            return 0;
        }
        int[][] dp = new int[A.length + 1][B.length + 1];
        int max = 0;
        for (int firstIndex = 1; firstIndex <= A.length; firstIndex++) {
            for (int secondIndex = 1; secondIndex <= B.length; secondIndex++) {
                if (A[firstIndex - 1] == B[secondIndex - 1]) {
                    dp[firstIndex][secondIndex] = dp[firstIndex - 1][secondIndex - 1] + 1;
                    max = Math.max(max, dp[firstIndex][secondIndex]);
                }
            }
        }
        return max;
    }
}
