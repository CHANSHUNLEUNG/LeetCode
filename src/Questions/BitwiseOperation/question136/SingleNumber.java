package Questions.BitwiseOperation.question136;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int answer = 0;
        for (int num : nums) {
            answer ^= num;
        }
        return answer;
    }
}
