package Questions.DynamicProgramming.question413;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length <= 2) {
            return 0;
        }
        int[] dp = new int[A.length];
        for (int index = 2; index < A.length; index++) {
            if(A[index] - A[index-1] == A[index-1] - A[index-2]){
                dp[index] = dp[index-1] +1;
            }
        }
        int count =0;
        for(int number : dp){
            count +=number;
        }
        return count;
    }

    public static void main(String[] argv) {
        NumberOfArithmeticSlices numberOfArithmeticSlices = new NumberOfArithmeticSlices();
        System.out.println(numberOfArithmeticSlices.numberOfArithmeticSlices(new int[]{-1, -2, -3}));
    }
}
