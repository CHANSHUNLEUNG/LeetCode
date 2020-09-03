package Questions.TwoPointers.question524;

import java.util.List;

public class LongestWord {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            if (target.length() < longestWord.length()
                    || (target.length() == longestWord.length() && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubsequence(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    private boolean isSubsequence(String s, String target) {
        int sIndex = 0, targetIndex = 0;
        for (sIndex = 0; sIndex < s.length(); sIndex++) {
            if (s.charAt(sIndex) == target.charAt(targetIndex)) {
                if(targetIndex == target.length()-1){
                    return true;
                }
                targetIndex++;
            }
        }
        return false;
    }

}
