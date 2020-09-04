package Questions.Searching.question90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        result.add(new ArrayList<>());
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> sequence = new ArrayList<>();
        for (int number = 1; number <= nums.length; number++) {
            doCombination(nums, number, 0, new boolean[nums.length], sequence, result);
        }
        return result;
    }

    private void doCombination(int[] nums, int number, int start,
                               boolean[] visited, List<Integer> sequence, List<List<Integer>> result) {
        if (sequence.size() == number) {
            result.add(new ArrayList<>(sequence));
            return;
        }
        for (int index = start; index < nums.length; index++) {
            if (index > 0 && nums[index] == nums[index - 1] && !visited[index - 1]) {
                continue;
            }
            visited[index] = true;
            sequence.add(nums[index]);
            doCombination(nums, number, index + 1, visited, sequence, result);
            visited[index] = false;
            sequence.remove(sequence.size() - 1);
        }
    }
}
