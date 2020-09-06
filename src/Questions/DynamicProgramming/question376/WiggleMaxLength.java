package Questions.DynamicProgramming.question376;

public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int up = 1, down = 1;
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] > nums[index - 1]) {
                up = down + 1;
            } else if (nums[index] < nums[index - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
