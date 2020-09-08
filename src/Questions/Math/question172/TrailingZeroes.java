package Questions.Math.question172;

public class TrailingZeroes {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] argv) {
        long number = 1;
        for (int i = 1; i <= 20; i++) {
            number *= i;
            System.out.println("i:" + i + ",number:" + number);
        }
    }
}
