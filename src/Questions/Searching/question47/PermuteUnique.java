package Questions.Searching.question47;

import java.util.ArrayList;
import java.util.List;

public class PermuteUnique {
    private int[] visited;
    private int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        this.nums = nums;
        this.visited = new int[nums.length];
        for (int index = 0; index < nums.length; index++) {
            List<Integer> sequence = new ArrayList<>();
            doCombination(sequence, index, result);
        }
        return result;
    }

    private void doCombination(List<Integer> sequence, int index, List<List<Integer>> result) {
        List<Integer> nextSequence = new ArrayList<>(sequence);
        nextSequence.add(nums[index]);
        if (nextSequence.size() == nums.length && !result.contains(nextSequence)) {
            result.add(nextSequence);
            return;
        }

        visited[index] = 1;
        for (int nextIndex = 0; nextIndex < nums.length; nextIndex++) {
            if (visited[nextIndex] == 0) {
                doCombination(nextSequence, nextIndex, result);
            }
        }
        visited[index] = 0;
    }
}
