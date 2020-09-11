package Questions.String.question796;

public class RotateString {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        String newA = A + A;
        return newA.contains(B);
    }
}
