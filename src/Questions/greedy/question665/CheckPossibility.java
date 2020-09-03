package Questions.greedy.question665;

public class CheckPossibility {
    public boolean checkPossibility(int[] nums) {
        int changedNumber = 0;
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] >= nums[index - 1]) {
                continue;
            }
            changedNumber++;
            if (index - 2 >= 0 && nums[index] < nums[index - 2]) {
                nums[index] = nums[index - 1];
            } else {
                nums[index - 1] = nums[index];
            }
        }
        return changedNumber <= 1;
    }
}
