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
//    public int findDuplicate(int[] nums) {
//        if (nums == null) {
//            return 0;
//        }
//        for (int index = 0; index < nums.length; index++) {
//            while (nums[index] != index + 1 && nums[index] != nums[nums[index] - 1]) {
//                swap(nums, index, nums[index] - 1);
//            }
//        }
//        for (int index = 0; index < nums.length; index++) {
//            if (nums[index] != index + 1) {
//                return nums[index];
//            }
//        }
//        return 0;
//    }
//
//    private void swap(int[] nums, int left, int right) {
//        int temp = nums[left];
//        nums[left] = nums[right];
//        nums[right] = temp;
//    }
//    public int findDuplicate(int[] nums) {
//        int left = 0, high = nums.length;
//        while (left < high) {
//            int middle = left + (high - left) / 2;
//            int count = 0;
//            for (int num : nums) {
//                if (num <= middle) {
//                    count++;
//                }
//            }
//            if (count <= middle) {
//                left = middle + 1;
//            } else {
//                high = middle - 1;
//            }
//        }
//        return left;
//    }
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
