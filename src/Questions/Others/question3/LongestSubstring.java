package Questions.Others.question3;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int length = s.length();
        int[] ascii = new int[128];
        for (int i = 0, j = 0; j < length; j++) {
            i = ascii[s.charAt(j)];
            ascii[s.charAt(j)] = j;
            answer = Math.max(answer, j - i + 1);
        }

        return answer;
    }

    public static void main(String[] argv) {
        System.out.println(new LongestSubstring().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstring().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }
}
