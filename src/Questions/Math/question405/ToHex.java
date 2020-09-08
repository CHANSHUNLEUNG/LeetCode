package Questions.Math.question405;

public class ToHex {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        String charMap = "0123456789abcdef";
        String answer = "";
        StringBuilder stringBuilder = new StringBuilder(answer);
        while (num != 0) {
            stringBuilder.append(charMap.charAt(num & 0b1111));
            num >>>= 4;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] argv) {
        int num = 10;
        System.out.println(new ToHex().toHex(-1));
    }
}
