package Questions.Tecent.back2020;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Question5 {
    public class  leotest{

    }
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int line = scanner.nextInt();
        int length = scanner.nextInt();
        int[][] nums = new int[length][2];
        for (int index = 0; index < line; index++) {
            nums[index][0] = scanner.nextInt();
            nums[index][1] = scanner.nextInt();
        }
        Arrays.sort(nums, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        int lastIndex = 0, end = 0;
        int count = 0;
        while (end < length) {
            int longest = -1;
            for (int index = lastIndex; index < nums.length; index++) {
                if (nums[index][0] > end) {
                    if (longest == -1) {
                        System.out.println(-1);
                        return;
                    }
                    lastIndex = index;
                    break;
                }
                longest = Math.max(longest, nums[index][1]);
            }
            count++;
            end = longest;
        }
        System.out.println(count);
    }
}
