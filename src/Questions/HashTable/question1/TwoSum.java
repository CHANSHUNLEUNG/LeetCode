package Questions.HashTable.question1;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int index=0;index<nums.length ; index++) {
            int complement = target - nums[index];
            if(hashMap.containsKey(complement)){
                return new int[]{index,hashMap.get(complement)};
            }
            hashMap.put(nums[index], index);
        }
        return null;
    }
}
