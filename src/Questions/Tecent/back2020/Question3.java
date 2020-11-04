package Questions.Tecent.back2020;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Question3 {
    private static int answer = 0;

    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int power = scanner.nextInt();
        int count = (int) Math.pow((double) 2, (double) power);
        int nums[] = new int[count];
        for (int index = 0; index < count; index++) {
            nums[index] = scanner.nextInt();
        }
        int times = scanner.nextInt();
        for (int index = 0; index < times; index++) {
            answer = 0;
            int currentPower = scanner.nextInt();
            int current = (int) Math.pow(2.0, (double) currentPower);
            solve(nums, current);
            System.out.println(answer);
        }

    }

    private static void solve(int[] nums, int current) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        for (int index = 0; index < nums.length / current; index++) {
            swap(nums, temp, index * current, index * current - 1 + current);
        }
        partition(nums, 0, nums.length - 1);
    }

    private static int[] partition(int[] nums, int start, int end) {
        if (start == end) {
            return new int[]{nums[start]};
        }
        int middle = start + (end - start) / 2;
        int[] left = partition(nums, start, middle);
        int[] right = partition(nums, middle + 1, end);
        int[] ret = new int[left.length + right.length];
        int leftPointer = 0, rightPointer = 0;
        for (int index = 0; index < ret.length; index++) {
            if (leftPointer >= left.length) {
                ret[index] = right[rightPointer++];
            } else if (rightPointer >= right.length) {
                ret[index] = left[leftPointer++];
            } else {
                if (left[leftPointer] <= right[rightPointer]) {
                    ret[index] = left[leftPointer++];
                } else {
                    ret[index] = right[rightPointer++];
                    answer += left.length - leftPointer;
                }
            }
        }
        return ret;
    }

    private static void swap(int[] nums, int[] temp, int start, int end) {
        int current = start;
        for (int index = end; index >= start; index--) {
            nums[index] = temp[current];
            current++;
        }
    }

}
