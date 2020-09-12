package Questions.BitwiseOperation.question260;

import java.util.*;

public class SingleNumber {
    public int[] singleNumber(int[] nums) {
//        if(nums==null){
//            return new int[]{};
//        }
//        Set<Integer> count = new HashSet<>();
//        for(int num:nums){
//            if(count.contains(num)){
//                count.remove(num);
//            }else{
//                count.add(num);
//            }
//        }
//        Iterator<Integer> iterator = count.iterator();
//        return new int[]{iterator.next(),iterator.next()};
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        int lowbit = sum & (-sum);
        int[] answer = new int[2];
        for (int num : nums) {
            if ((num & lowbit) != 0) {
                answer[0] ^= num;
            } else {
                answer[1] ^= num;
            }
        }
        return answer;
    }
}
