package Questions.String.question151;

public class ReverseWords {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        String answer = "";
        for (int index = words.length - 1; index >= 0; index--) {
            answer += (index == 0) ? words[index] : words[index] + " ";
        }
        return answer;
    }
}
