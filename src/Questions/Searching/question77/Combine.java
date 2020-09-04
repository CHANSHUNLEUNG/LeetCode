package Questions.Searching.question77;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();
        doCombination(n, k, 1, sequence, result);
        return result;
    }

    private void doCombination(int n, int k, int start, List<Integer> sequence, List<List<Integer>> result) {
//        1.final recusion return
//        2. recusion
        if (k == 0) {
            result.add(new ArrayList<>(sequence));
            return;
        }

        for (int index = start; index <= n; index++) {
            sequence.add(index);
            doCombination(n, k - 1, index + 1, sequence, result);
            sequence.remove(sequence.size() - 1);
        }
    }
}
