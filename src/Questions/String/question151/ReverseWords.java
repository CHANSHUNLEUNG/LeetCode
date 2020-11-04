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
    public static void main(String[] argv){
        int test = 10;
        StringBuilder sb = new StringBuilder(String.valueOf(test));
        System.out.println(sb.toString());
        System.out.println(sb.reverse().toString());
    }
}
