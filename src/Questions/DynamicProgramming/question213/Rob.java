package Questions.DynamicProgramming.question213;

public class Rob {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(robSum(nums, 0, nums.length - 1), robSum(nums, 1, nums.length));
    }

    private int robSum(int[] nums, int start, int end) {
        int pre2 = 0;
        int pre1 = 0;
        for (int index = start; index < end; index++) {
            int current = Math.max(pre2 + nums[index], pre1);
            pre2 = pre1;
            pre1 = current;
        }
        return pre1;
    }

}
