package Questions.Math.question462;

import java.util.Arrays;

public class MinMoves2 {
    public int minMoves2(int[] nums) {
        int middleIndex = nums.length / 2;
        int answer = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == middleIndex) {
                break;
            } else if (pivotIndex > middleIndex) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
        for (int num : nums) {
            answer += Math.abs(num - nums[middleIndex]);
        }
        return answer;
    }

    private int partition(int[] nums, int left, int right) {
        int pivotIndex = left;
        int rightBackup = right;
        while (right >= pivotIndex) {
            if (nums[rightBackup] > nums[right]) {
                swap(nums, pivotIndex, right);
                pivotIndex++;
                continue;
            }
            right--;
        }
        swap(nums, pivotIndex, rightBackup);
        return pivotIndex;
    }

    public void random(int[] nums) {
        for (int index = 0; index < nums.length; index++) {
            int randomIndex = (int) Math.random() * nums.length;
            swap(nums, index, randomIndex);
        }
    }

    public void swap(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }

    public static void main(String[] argv) {
        System.out.println(new MinMoves2().minMoves2(new int[]{1, 2, 3}));
    }
}
