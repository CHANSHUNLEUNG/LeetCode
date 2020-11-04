package Questions.Tecent.back2018;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long minus = (long) (1 + m) * m / 2;
        long plus = (long) (m + 1 + 2 * m) * m / 2;
        long number = plus - minus;
        System.out.println(number * (n / 2 / m));
    }
}
