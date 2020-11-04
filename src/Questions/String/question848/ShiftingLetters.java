package Questions.String.question848;

public class ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        if (shifts == null) {
            return "";
        }
        int count = 0;
        String answer = "";
        for (int index = shifts.length - 1; index >= 0; index--) {
            count += shifts[index] % 26;
            answer = afterShift(S.charAt(index), count) + answer;

        }
        StringBuilder test = new StringBuilder();
        return answer;
    }

    private char afterShift(char character, int times) {
        return (char) ((character - 'a' + times) % 26 + 'a');
    }

    public static void main(String[] argv) {
        System.out.println(new ShiftingLetters().afterShift('b', 53));
    }
}
