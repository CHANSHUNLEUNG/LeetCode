package Questions.Tecent.back2018;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Question4 {

    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int k = scanner.nextInt();
        int lengthA = scanner.nextInt();
        int numberA = scanner.nextInt();
        int lengthB = scanner.nextInt();
        int numberB = scanner.nextInt();
        int dp[] = new int[k + 1];
        int nums[] = new int[numberA + numberB];
        for (int index = 0; index < numberA; index++) {
            nums[index] = lengthA;
        }
        for (int index = numberA; index < numberA + numberB; index++) {
            nums[index] = lengthB;
        }
        int mod = 1000000007;
        dp[0] = 1;
        for (int index = 0; index < numberA + numberB; index++) {
            for (int inner = k; inner >= 0; inner--) {
                if (inner - nums[index] >= 0) {
                    dp[inner] = (dp[inner] % mod + dp[inner - nums[index]] % mod) % mod;
                }
            }
        }
        System.out.println(dp[k]);
    }
}
