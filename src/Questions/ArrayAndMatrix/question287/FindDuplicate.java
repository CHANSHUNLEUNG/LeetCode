package Questions.ArrayAndMatrix.question287;

import java.util.Arrays;

public class FindDuplicate {
    //    public int findDuplicate(int[] nums) {
//        int[] counts = new int[nums.length];
//        for (int num : nums) {
//            counts[num]++;
//        }
//        for (int index=0;index<counts.length;index++){
//            if(counts[index] == 2){
//                return index;
//            }
//        }
//        return 0;
//    }
    public int findDuplicate(int[] nums) {
        if (nums == null) {
            return 0;
        }
        for (int index = 0; index < nums.length; index++) {
            while (nums[index] != index + 1 && nums[index] != nums[nums[index] - 1]) {
                swap(nums, index, nums[index] - 1);
            }
        }
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                return nums[index];
            }
        }
        return 0;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
