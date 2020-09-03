package Questions.Others.question1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int complement = target - nums[index];
            if(myMap.containsKey(complement) && myMap.get(complement) != index){
                return new int[] {index,myMap.get(complement)};
            }
            myMap.put(nums[index], index);
        }
        throw new IllegalArgumentException("No solution");
    }

    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        TwoSum solution = new TwoSum();
        int[] numbers = solution.twoSum(input, 9);
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
