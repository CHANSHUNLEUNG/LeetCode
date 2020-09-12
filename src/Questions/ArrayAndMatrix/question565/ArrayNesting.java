package Questions.ArrayAndMatrix.question565;

public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        for (int index = 0; index < nums.length; index++) {
            int count = 0;
            int current = nums[index];
            while (current != -1 && nums[current] != -1) {
                int temp = nums[current];
                nums[current] = -1;
                current = temp;
                count++;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}
