package Questions.ArrayAndMatrix.question645;

import java.util.Arrays;

public class FindErrorNums {
    //    public int[] findErrorNums(int[] nums) {
//        if (nums == null) {
//            return null;
//        }
//        int[] counts = new int[nums.length+1];
//        for(int num:nums){
//            counts[num]++;
//        }
//        int[] answer = new int[2];
//        int twice = 0;
//        int miss = 0;
//        for(int index=1;index<counts.length;index++){
//            if(counts[index]==0){
//                miss = index;
//            }else if(counts[index] == 2){
//                twice = index;
//            }
//        }
//        return new int[]{twice,miss};
//    }
    public int[] findErrorNums(int[] nums) {
        if (nums == null) {
            return null;
        }
        for (int index = 0; index < nums.length; index++) {
            while (nums[index] != index + 1 && nums[index] != nums[nums[index] - 1]) {
                swap(nums, index, nums[index] - 1);
            }
        }
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                return new int[]{nums[index], index + 1};
            }
        }
        return null;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
