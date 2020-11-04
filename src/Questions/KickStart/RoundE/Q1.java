package Questions.KickStart.RoundE;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q1 {
    private static int solve(int number, int[] nums) {
        if(nums.length <= 2){
            return nums.length;
        }
        int max = 2;
        int count = 2;
        for(int index=2; index<nums.length; index++){
            if(nums[index] - nums[index-1] == nums[index-1] - nums[index-2]){
                count++;
                max = Math.max(max, count);
            }else{
                count = 2;
            }
        }
        return max;
    }

    public static void main(String[] argv) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(bf.readLine());
        for(int testNumber=1; testNumber<=test; testNumber++){
            int number = Integer.parseInt(bf.readLine());
            String[] stringArray = bf.readLine().split(" ");
            int[] nums = new int[stringArray.length];
            for (int index = 0; index < stringArray.length; index++) {
                nums[index] = Integer.parseInt(stringArray[index]);
            }
            int answer = solve(number, nums);
            System.out.println("Case #" + testNumber + ": " + answer);
        }
        bf.close();
    }

}
