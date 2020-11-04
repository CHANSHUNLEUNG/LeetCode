package Questions.BitwiseOperation.question371;

import java.util.Arrays;

public class GetSum {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum((a ^ b), (a & b) << 1);
    }

    public static void main(String[] argv){
        int[][] nums = new int[3][2];
        nums[0][0] = 1;
        nums[0][1] = 3;
        nums[1][0] = 1;
        nums[1][1] = 2;
        nums[2][0] = 0;
        nums[2][1] = 4;
//        int[][] copy = Arrays.stream(nums).map(a -> Arrays.copyOf(a,a.length)).toArray(int[][]::new);
//        int[][] copy = Arrays.copyOf(nums,nums.length);
//        copy[1][1] = 5;
//        System.out.println(copy[0][0]);
//        System.out.println(copy[0][1]);
//        System.out.println(copy[1][0]);
//        System.out.println(copy[1][1]);

        Arrays.sort(nums,(x,y) -> x[0] == y[0] ?  x[1] - y[1] : x[0] - y[0]);
        System.out.println(nums[0][0]);
        System.out.println(nums[0][1]);
        System.out.println(nums[1][0]);
        System.out.println(nums[1][1]);
        System.out.println(nums[2][0]);
        System.out.println(nums[2][1]);
    }
}
