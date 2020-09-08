package Questions.DynamicProgramming.question583;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int word1Length = word1.length(), word2Length = word2.length();
        int[][] dp = new int[word1Length + 1][word2Length + 1];
        for (int word1Index = 1; word1Index < dp.length; word1Index++) {
            for (int word2Index = 1; word2Index < dp[0].length; word2Index++) {
                char char1 = word1.charAt(word1Index-1);
                char char2 = word2.charAt(word2Index-1);
                if (char1 != char2) {
                    dp[word1Index][word2Index] = Math.max(dp[word1Index - 1][word2Index], dp[word1Index][word2Index - 1]);
                } else {
                    dp[word1Index][word2Index] = dp[word1Index - 1][word2Index - 1] + 1;
                }
            }
        }
        int maxSubsequenceNumber = dp[word1Length][word2Length];
        return word1.length() + word2.length() - 2 * maxSubsequenceNumber;
    }
}
