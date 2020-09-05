package Questions.DynamicProgramming.question198;

public class Rob {
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int pre2 = 0, pre1 = 0;
        for (int index = 0; index < nums.length; index++) {
            int currentMax = Math.max(pre2 + nums[index], pre1);
            pre2 = pre1;
            pre1 = currentMax;
        }
        return pre1;
    }
}
