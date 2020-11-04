package Questions.ByteDance.Spring2019;

import java.io.BufferedInputStream;
import java.util.Scanner;
//dp[0]{1,2,3} = dp[1]{2,3} + position[1][0], dp[2]{1,3} + position[2][0], dp[3]{1,2} + position[3][0]
//dp[1]{2,3} = dp[2]{3} + position[2][1], dp[3]{2} + position[3][1]
//dp[m]{}    在m点，已经经过{}

//init: dp[1-m]{} = position[1-m][0]
//calculate order:
//dp[]

public class Question5 {
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] argv){
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int rows = scanner.nextInt();
        int nums[][] = new int[rows][rows];
        for(int row=0; row<rows; row++){
            for(int col=0; col<rows; col++){
                nums[row][col] = scanner.nextInt();
//                System.out.println(nums[row][col]);
            }
        }
        int bin = 1 << (rows-1);
        int dp[][] = new int[rows][bin];
        for(int index=0; index<rows; index++){
            dp[index][0] = nums[index][0];
        }
        for(int myset=1; myset<bin; myset++){
            for(int city=1; city<rows; city++){
                dp[city][myset] = Integer.MAX_VALUE;
                if(((myset >> (city-1)) & 1 ) == 1){
                    continue;
                }
                for(int fromCity=1;fromCity<rows; fromCity++){
                    if(((myset>>(fromCity-1)) & 1) == 0){
                        continue;
                    }
                    dp[city][myset] = Math.min(dp[city][myset], dp[fromCity][myset^(1<<(fromCity-1))] + nums[fromCity][city]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int index=1; index<rows; index++){
            min = Math.min(min, dp[index][(bin-1)^(1<<(index-1))] + nums[index][0]);
        }
        System.out.println(min);
        System.out.println(dp[0][bin-1]);
    }

}
//4
//0 2 6 5
//2 0 4 4
//6 4 0 2
//5 4 2 0