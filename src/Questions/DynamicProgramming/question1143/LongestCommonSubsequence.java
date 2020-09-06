package Questions.DynamicProgramming.question1143;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int firstIndex = 1; firstIndex <= text1.length(); firstIndex++) {
            for (int secondIndex = 1; secondIndex <= text2.length(); secondIndex++) {
                if (text1.charAt(firstIndex - 1) == text2.charAt(secondIndex - 1)) {
                    dp[firstIndex][secondIndex] = dp[firstIndex - 1][secondIndex - 1] + 1;
                } else {
                    dp[firstIndex][secondIndex] = Math.max(dp[firstIndex - 1][secondIndex], dp[firstIndex][secondIndex - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

}
