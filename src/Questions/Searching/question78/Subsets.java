package Questions.Searching.question78;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        result.add(new ArrayList<>());
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        List<Integer> sequence = new ArrayList<>();
        for (int number = 1; number <= nums.length; number++) {
            doCombination(nums, number, 0, sequence, result);
        }
        return result;
    }

    private void doCombination(int[] nums, int number, int start, List<Integer> sequence, List<List<Integer>> result) {
        if (sequence.size() == number) {
            result.add(new ArrayList<>(sequence));
            return;
        } else if (sequence.size() > number) {
            return;
        }
        for (int index = start; index < nums.length; index++) {
            sequence.add(nums[index]);
            doCombination(nums, number, index + 1, sequence, result);
            sequence.remove(sequence.size() - 1);
        }
    }
}
