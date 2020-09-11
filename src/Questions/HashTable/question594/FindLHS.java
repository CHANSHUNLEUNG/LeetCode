package Questions.HashTable.question594;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindLHS {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (int num : nums) {
            if (countMap.containsKey(num + 1)) {
                max = Math.max(max, countMap.get(num + 1) + countMap.get(num));
            }
        }
        return max;
    }
}
