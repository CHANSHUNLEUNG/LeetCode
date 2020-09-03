package Questions.TwoPointers.question345;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
//    private final static HashSet<Character> vowelSet = new HashSet<>(
//            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        if(s == null) return null;
        int start = 0, end = s.length() - 1;
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] answer = new char[s.length()];
        while (start < end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            boolean leftContain = vowelSet.contains(startChar);
            boolean rightContain = vowelSet.contains(endChar);
            if (!leftContain) {
                answer[start++] = startChar;
            }
            if (!rightContain) {
                answer[end--] = endChar;
            }
            if(leftContain && rightContain){
                answer[start++] = endChar;
                answer[end--] = startChar;
            }

        }
        return new String(answer);
    }

    public static void main(String[] argv) {
        System.out.println("test".contains("f"));
    }
}
