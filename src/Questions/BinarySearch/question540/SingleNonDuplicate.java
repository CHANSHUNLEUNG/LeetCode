package Questions.BinarySearch.question540;

public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (isAnswer(nums, middle)) {
                return nums[middle];
            } else if (moveRightIndex(nums, middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    private boolean moveRightIndex(int[] nums, int middle) {
        if (middle == 0) {
            return false;
        } else if (middle == nums.length - 1) {
            return true;
        }
        if (nums[middle + 1] == nums[middle]) {
            return (middle + 1) % 2 == 0;
        } else {
            return middle % 2 == 0;
        }
    }

    private boolean isAnswer(int[] nums, int middle) {
        if (middle == 0) {
            return !(nums[middle + 1] == nums[middle]);
        } else if (middle == nums.length - 1) {
            return !(nums[middle - 1] == nums[middle]);
        } else {
            return !(nums[middle + 1] == nums[middle] || nums[middle - 1] == nums[middle]);
        }
    }

    public int secondSolution(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (middle % 2 != 0) {
                middle--;
            }
            if (nums[middle + 1] == nums[middle]) {
                left = middle + 2;
            } else {
                right = middle;
            }
        }
        return nums[left];
    }
}
