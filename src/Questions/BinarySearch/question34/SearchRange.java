package Questions.BinarySearch.question34;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int firstPosition = findPosition(nums, target);
        int lastPosition = findPosition(nums, target + 1) - 1;
        if (firstPosition == nums.length || nums[firstPosition] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{firstPosition, Math.max(firstPosition, lastPosition)};
    }

    public int findPosition(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] >= target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public static void main(String[] argv) {

    }

}
