package Questions.greedy.question53;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0], submax = nums[0];
        for (int index = 1; index < nums.length; index++) {
            submax = submax > 0 ? submax + nums[index] : nums[index];
            max = Math.max(max, submax);
        }
        return max;
    }
}
