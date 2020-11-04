package Questions.ByteDance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question2 {
    public static void main(String[] argv) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numbers = Integer.parseInt(bf.readLine());
        String[] info = bf.readLine().split(" ");
        int[] nums = new int[info.length];
        for(int index=0; index<numbers; index++){
            nums[index] = Integer.parseInt(info[index]);
        }
        int max = 0 ;
        for(int index=0; index< numbers;index++){
            int current = 0;
            int min = 101;
            for(int compareIndex=index;compareIndex<numbers;compareIndex++){
                current += nums[compareIndex];
                min = Math.min(min, nums[compareIndex]);
                max = Math.max(max, current * min);
            }
        }
        System.out.println(max);
        bf.close();
    }
}
