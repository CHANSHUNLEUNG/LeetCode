package Questions.Searching.question17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinations {
    private static final String[] keys = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        doCombination("", digits, result);
        return result;
    }

    private void doCombination(String prefix, String digits, List<String> result) {
        if (prefix.length() == digits.length()) {
            result.add(prefix);
            return;
        }
        int digit = digits.charAt(prefix.length()) - '0';
        for (char character : keys[digit - 2].toCharArray()) {
            String nextPrefix = prefix + character;
            doCombination(nextPrefix, digits, result);
        }
    }
}
