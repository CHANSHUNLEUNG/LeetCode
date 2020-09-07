package Questions.DynamicProgramming.question139;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int prefix = 1; prefix <= s.length(); prefix++) {
            for (String word : wordDict) {
                int wordLength = word.length();
                if (prefix - wordLength >= 0 && s.substring(prefix - wordLength, prefix).equals(word) && dp[prefix - wordLength]) {
                    dp[prefix] = true;
                }
            }
        }
        return dp[s.length()];
    }

}
