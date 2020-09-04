package Questions.Searching.question46;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int num : nums) {
            List<Integer> sequence = new ArrayList<>();
            doCombination(sequence, num, nums, result);
        }
        return result;
    }

    private void doCombination(List<Integer> sequence, int num, int nums[], List<List<Integer>> result) {
        List<Integer> nextSequence = new ArrayList<>(sequence);
        nextSequence.add(num);

        if (nextSequence.size() == nums.length) {
            result.add(nextSequence);
            return;
        }
        for (int next : nums) {
            if (!nextSequence.contains(next)) {
                doCombination(nextSequence, next, nums, result);
            }
        }
    }

    public static void main(String[] argv) {
        Permute permute = new Permute();
        System.out.println(permute.permute(new int[]{1, 2, 3}));
    }

}
