package Questions.Math.question415;

import Questions.Math.question67.AddBinary;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        if (num2.length() > num1.length()) {
            return addStrings(num2, num1);
        }
        String answer = "";
        int carry = 0;
        for (int right = 0; right < num1.length(); right++) {
            int number1 = num1.charAt(num1.length() - 1 - right) - '0';
            int number2 = 0;
            if (num2.length() - 1 - right >= 0) {
                number2 = num2.charAt(num2.length() - 1 - right) - '0';
            }
            answer = (number1 + number2 + carry) % 10 + answer;
            carry = (number1 + number2 + carry) >= 10 ? 1 : 0;
        }
        if (carry == 1) {
            answer = "1" + answer;
        }
        return answer;
    }

    public static void main(String[] argv) {
        System.out.println(new AddStrings().addStrings("9", "99"));
    }
}
