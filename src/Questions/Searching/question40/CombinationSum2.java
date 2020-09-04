package Questions.Searching.question40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (target <= 0 || candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> sequence = new ArrayList<>();
        doCombination(candidates, target, 0, new boolean[candidates.length], sequence, result);
        return result;
    }

    private void doCombination(int[] candidates, int target, int start, boolean[] visited,
                               List<Integer> sequence, List<List<Integer>> result) {
        int sum = sequence.stream().mapToInt(x -> x).sum();
        if (sum == target) {
            result.add(new ArrayList<>(sequence));
            return;
        }
        if (sum < target) {
            for (int index = start; index < candidates.length; index++) {
                if (index > 0 && candidates[index] == candidates[index - 1] && !visited[index - 1]) {
                    continue;
                }
                sequence.add(candidates[index]);
                visited[index] = true;
                doCombination(candidates, target, index + 1, visited, sequence, result);
                visited[index] = false;
                sequence.remove(sequence.size() - 1);
            }
        }
    }
}
