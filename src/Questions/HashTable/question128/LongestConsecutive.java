package Questions.HashTable.question128;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {
    //    public int longestConsecutive(int[] nums) {
//        if(nums == null || nums.length == 0){
//            return 0;
//        }
//        Arrays.sort(nums);
//        int max = 1;
//        int count = 1;
//        for (int index = 1; index < nums.length; index++) {
//            if (nums[index] - 1 == nums[index - 1]) {
//                count++;
//            } else if(nums[index] != nums[index-1]) {
//                count = 1;
//            }
//            max = Math.max(max, count);
//        }
//        return max;
//    }
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, 1);
        }
        int max = 1;
        for (int num : nums) {
            if (countMap.get(num) != 1) {
                continue;
            }
            int current = num + 1;
            int count = 1;
            while (countMap.containsKey(current)) {
                countMap.put(current, 2);
                count++;
                current++;
            }
            current = num - 1;
            while (countMap.containsKey(current)) {
                countMap.put(current, 2);
                count++;
                current--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
