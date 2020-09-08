package Questions.Math.question67;

public class AddBinary {
    public String addBinary(String a, String b) {
        if (b.length() > a.length()) {
            return addBinary(b, a);
        }
        String answer = "";
        int carry = 0;

        for (int right = 0; right < a.length(); right++) {
            int numberA = (int) (a.charAt(a.length() - 1 - right) - '0');
            int numberB = 0;
            if (b.length() - 1 - right >= 0) {
                numberB = (int) (b.charAt(b.length() - 1 - right) - '0');
            }
            int current = (carry + numberA + numberB) % 2;
            answer = current + answer;
            carry = carry + numberA + numberB >= 2 ? 1 : 0;
        }
        if (carry == 1) {
            answer = "1" + answer;
        }
        return answer;
    }

    public static void main(String[] argv) {
        System.out.println(new AddBinary().addBinary("010101", "11111"));
    }
}
