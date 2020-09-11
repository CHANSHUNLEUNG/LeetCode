package Questions.String.question696;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int answer = 0;
        int zeros = 0, ones = 0;
        for (int index = 0; index < s.length(); index++) {
            char current = s.charAt(index);
            if (current == '0') {
                if (index != 0 && s.charAt(index - 1) == '1') {
                    zeros = 0;
                }
                zeros++;
                if (ones != 0) {
                    ones--;
                    answer++;
                }
            } else {
                if (index != 0 && s.charAt(index - 1) == '0') {
                    ones = 0;
                }
                ones++;
                if (zeros != 0) {
                    zeros--;
                    answer++;
                }
            }
        }
        return answer;
    }
}
