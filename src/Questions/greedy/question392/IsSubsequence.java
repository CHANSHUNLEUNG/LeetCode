package Questions.greedy.question392;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char character : s.toCharArray()) {
            index = t.indexOf(character, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
