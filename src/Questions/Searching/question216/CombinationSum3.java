package Questions.Searching.question216;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 0 || n == 0) {
            return result;
        }
        List<Integer> sequence = new ArrayList<>();
        doCombincation(k, n, sequence, result, 1);
        return result;
    }

    private void doCombincation(int k, int n, List<Integer> sequence, List<List<Integer>> result, int start) {
        int sum = sequence.stream().mapToInt(x -> x).sum();
        if (sequence.size() == k && sum == n) {
            result.add(new ArrayList<>(sequence));
            return;
        }
        if (sequence.size() > k) {
            return;
        }
        for (int index = start; index <= 9; index++) {
            sequence.add(index);
            doCombincation(k, n, sequence, result, index + 1);
            sequence.remove(sequence.size() - 1);
        }
    }
}
