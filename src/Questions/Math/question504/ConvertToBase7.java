package Questions.Math.question504;

public class ConvertToBase7 {
    public String convertToBase7(int num) {
        boolean negative = num < 0;
        if (negative) {
            num = -num;
        }
        String answer = "";
        int copyNum = num, maxPower = 0;
        while (copyNum >= 7) {
            maxPower++;
            copyNum /= 7;
        }
        while (maxPower >= 0) {
            int divisor = (int) Math.pow(7, maxPower);
            answer += String.valueOf(num / divisor);
            num = num % divisor;
            maxPower--;
        }
        return negative ? "-" + answer : answer;
    }

    public static void main(String[] argv) {
        System.out.println(new ConvertToBase7().convertToBase7(-7));
    }
}
