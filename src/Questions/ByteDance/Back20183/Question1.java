package Questions.ByteDance.Back20183;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

// 6 directions
// backtracking 5
public class Question1 {
    private static int max = 0;
    public static void main(String[] argv){
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int nums[] = new int[24];
        for(int index=0; index<24; index++){
            nums[index] = scanner.nextInt();
        }
        backTracking(nums,0);
        System.out.println(max);
    }
    public static void backTracking(int[]nums, int current){
        max = Math.max(max, calculate(nums));
        if(current == 5){
            return;
        }
        //xia nishizhen
        int[] temp = Arrays.copyOf(nums,nums.length);
        xiaShun(temp);
        backTracking(temp,current+1);

        temp = Arrays.copyOf(nums,nums.length);
        xiaNi(temp);
        backTracking(temp,current+1);

        temp = Arrays.copyOf(nums,nums.length);
        zuoShun(temp);
        backTracking(temp,current+1);

        temp = Arrays.copyOf(nums,nums.length);
        zuoNi(temp);
        backTracking(temp,current+1);

        temp = Arrays.copyOf(nums,nums.length);
        houShun(temp);
        backTracking(temp,current+1);

        temp = Arrays.copyOf(nums,nums.length);
        houNi(temp);
        backTracking(temp,current+1);

    }
//guo
    private static void houNi(int[] temp) {
        houShun(temp);
        houShun(temp);
        houShun(temp);
    }
//guo
    private static void houShun(int[] temp) {
        int ori[] = Arrays.copyOf(temp,temp.length);
        temp[23] = ori[8];
        temp[22] = ori[9];
        temp[5] = ori[22];
        temp[4] = ori[23];
        temp[7] = ori[5];
        temp[6] = ori[4];
        temp[8] = ori[6];
        temp[9] = ori[7];

        temp[0] = ori[1];
        temp[2] = ori[0];
        temp[3] = ori[2];
        temp[1] = ori[3];
    }
//guo
    private static void zuoNi(int[] temp) {
        zuoShun(temp);
        zuoShun(temp);
        zuoShun(temp);
    }
//guo
    private static void zuoShun(int[] temp) {
        int ori[] = Arrays.copyOf(temp,temp.length);
        temp[22] = ori[2];
        temp[20] = ori[0];
        temp[18] = ori[22];
        temp[16] = ori[20];
        temp[6] = ori[16];
        temp[12] = ori[18];
        temp[0] = ori[6];
        temp[2] = ori[12];

        temp[4] = ori[5];
        temp[10] = ori[4];
        temp[11] = ori[10];
        temp[5] = ori[11];

    }

    private static void xiaNi(int[] temp) {
        xiaShun(temp);
        xiaShun(temp);
        xiaShun(temp);
    }

    private static void xiaShun(int[] temp) {
        int ori[] = Arrays.copyOf(temp,temp.length);
        temp[8] = ori[2];
        temp[14] = ori[3];
        temp[17] = ori[8];
        temp[16] = ori[14];
        temp[11] = ori[17];
        temp[5] = ori[16];
        temp[3] = ori[5];
        temp[2] = ori[11];

        temp[13] = ori[7];
        temp[12] = ori[13];
        temp[6] = ori[12];
        temp[7] = ori[6];

    }

    private static int calculate(int[] nums) {
        int ret = 0;
        ret += nums[0] * nums[1] * nums[2] * nums[3];
        ret += nums[4] * nums[5] * nums[10] * nums[11];
        ret += nums[8] * nums[9] * nums[14] * nums[15];
        ret += nums[16] * nums[17] * nums[18] * nums[19];
        ret += nums[23] * nums[22] * nums[21] * nums[20];
        ret += nums[6] * nums[7] * nums[12] * nums[13];
        return ret;
    }
}

//2 -3 -2 3 7 -6 -6 -7 9 -5 -9 -3 -2 1 4 -9 -1 -10 -5 -5 -10 -4 8 2
