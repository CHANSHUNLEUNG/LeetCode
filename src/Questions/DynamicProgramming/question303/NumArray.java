package Questions.DynamicProgramming.question303;

public class NumArray {
    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int index = 0; index <= nums.length; index++) {
            sum[index] = (index == 0) ? 0 : sum[index - 1] + nums[index-1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */