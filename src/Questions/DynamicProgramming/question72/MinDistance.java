package Questions.DynamicProgramming.question72;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int index = 0; index <= l1; index++) {
            dp[index][0] = index;
        }
        for (int index = 0; index <= l2; index++) {
            dp[0][index] = index;
        }
        for (int word1Index = 1; word1Index <= l1; word1Index++) {
            for (int word2Index = 1; word2Index <= l2; word2Index++) {
                if (word1.charAt(word1Index - 1) == word2.charAt(word2Index - 1)) {
                    dp[word1Index][word2Index] = dp[word1Index - 1][word2Index - 1];
                } else {
                    dp[word1Index][word2Index] = 1 + Math.min(dp[word1Index - 1][word2Index - 1],
                            Math.min(dp[word1Index][word2Index - 1], dp[word1Index - 1][word2Index]));
                }
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] argv) {
        System.out.println(new MinDistance().minDistance("intention", "execution"));
    }
}
