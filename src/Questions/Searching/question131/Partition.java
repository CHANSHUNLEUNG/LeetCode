package Questions.Searching.question131;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        List<String> sequence = new ArrayList<>();
        for (int number = 1; number <= s.length(); number++) {
            doCombination(s, number, 0, sequence, result);
        }
        return result;
    }

    private void doCombination(String s, int number, int start, List<String> sequence, List<List<String>> result) {
        int sequenceLength = sequence.stream().mapToInt(str -> str.length()).sum();
        if (sequence.size() == number && sequenceLength == s.length()) {
            result.add(new ArrayList<>(sequence));
            return;
        }
        if (sequence.size() >= number) {
            return;
        }
        for (int index = start; index < s.length(); index++) {
            String nextString = s.substring(start, index + 1);
            if (!isPalidrome(nextString)) {
                continue;
            }
            sequence.add(s.substring(start, index + 1));
            doCombination(s, number, index + 1, sequence, result);
            sequence.remove(sequence.size() - 1);
        }
    }

    private boolean isPalidrome(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int start = 0, end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
