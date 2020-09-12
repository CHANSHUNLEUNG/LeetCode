package Questions.BitwiseOperation.question268;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
//        Math
//        int sum = (1 + nums.length) * nums.length / 2;
//        for(int num : nums){
//            sum -= num;
//        }
//        return sum;

//        Sort
//        Arrays.sort(nums);
//        // Ensure that n is at the last index
//        if (nums[nums.length-1] != nums.length) {
//            return nums.length;
//        }
//        // Ensure that 0 is at the first index
//        else if (nums[0] != 0) {
//            return 0;
//        }
//        for (int index = 1; index < nums.length; index++) {
//            if (nums[index] != nums[index - 1] + 1) {
//                return nums[index] - 1;
//            }
//        }
//        return -1;
        int answer = 0;
        for (int index = 0; index < nums.length; index++) {
            answer ^= index ^nums[index];
        }
        return answer ^ nums.length;
    }
}
