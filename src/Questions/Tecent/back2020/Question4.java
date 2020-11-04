package Questions.Tecent.back2020;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Question4 {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int count = scanner.nextInt();
        int work[] = new int[count];
        int dym[] = new int[count];
        for (int index = 0; index < count; index++) {
            work[index] = scanner.nextInt();
        }
        for (int index = 0; index < count; index++) {
            dym[index] = scanner.nextInt();
        }
        int dp[][] = new int[count + 1][3];
        // 0 rest 1 work 2 dym
        for (int index = 0; index < count; index++) {
            if (work[index] == 0 && dym[index] == 0) {
                dp[index + 1][0] = Math.min(dp[index][0], Math.min(dp[index][1], dp[index][2])) + 1;
                dp[index + 1][1] = Integer.MAX_VALUE;
                dp[index + 1][2] = Integer.MAX_VALUE;
            } else if (work[index] == 1 && dym[index] == 0) {
                dp[index+1][0] = Math.min(dp[index][0], Math.min(dp[index][1], dp[index][2])) + 1;
                dp[index+1][1] = Math.min(dp[index][0],dp[index][2]);
                dp[index+1][2] = Integer.MAX_VALUE;
            } else if (work[index] == 0 && dym[index] == 1) {
                dp[index+1][0] = Math.min(dp[index][0], Math.min(dp[index][1], dp[index][2])) + 1;
                dp[index+1][1] = Integer.MAX_VALUE;
                dp[index+1][2] = Math.min(dp[index][0] , dp[index][1]);
            } else {
                dp[index+1][0] = Math.min(dp[index][0], Math.min(dp[index][1], dp[index][2])) + 1;
                dp[index+1][1] = Math.min(dp[index][0], dp[index][2]);
                dp[index+1][2] = Math.min(dp[index][0], dp[index][1]);
            }
        }

        System.out.println(Math.min(dp[count][0], Math.min(dp[count][1], dp[count][2])));
    }
}
