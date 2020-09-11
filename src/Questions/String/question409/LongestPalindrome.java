package Questions.String.question409;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] counts = new int[256];
        int answer = 0;
        boolean haveMiddle = false;
        for (char character : s.toCharArray()) {
            counts[character]++;
        }
        for (int count : counts) {
            answer += count / 2 * 2;
            haveMiddle = count % 2 == 1 ? true : haveMiddle;
        }
        if (haveMiddle) answer++;
        return answer;
    }
}
