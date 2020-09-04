package Questions.Searching.question36;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (target <= 0 || candidates == null || candidates.length == 0) {
            return result;
        }
        List<Integer> combineList = new ArrayList<>();
        doCombination(candidates, target, 0, combineList, result);
        return result;
    }

    private void doCombination(int[] candidates, int target, int start, List<Integer> combineList, List<List<Integer>> result) {
        int sum = combineList.stream().mapToInt(x -> x).sum();
        if (sum == target) {
            result.add(new ArrayList<>(combineList));
            return;
        }
        if (sum < target) {
            for (int index = start; index < candidates.length; index++) {
                combineList.add(candidates[index]);
                doCombination(candidates, target, index, combineList, result);
                combineList.remove(combineList.size() - 1);
            }
        }
    }

}
