package Questions.ByteDance.Algor2018;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Question2 {
    private static int max = 0;

    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int number = scanner.nextInt();
        int nums[] = new int[number];
        for (int index = 0; index < number; index++) {
            nums[index] = scanner.nextInt();
        }
        for (int index = 0; index < number; index++) {
            int left = index - 1, right = index + 1;
            int sum = nums[index];
            while (right < number && nums[right] >= nums[index]) {
                sum += nums[right];
                right++;
            }
            while (left >= 0 && nums[left] >= nums[index]) {
                sum += nums[left];
                left--;
            }
            max = Math.max(max, sum * nums[index]);
        }
        System.out.println(max);
    }
}
