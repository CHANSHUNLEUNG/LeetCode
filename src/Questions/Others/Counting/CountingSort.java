package Questions.Others.Counting;

import java.util.*;

public class CountingSort {
    public void countingSort(int[] nums){
        //Check edge cases
        if(nums == null){
            return;
        }
        int counts[] = new int[101];
        for(int index=0; index<nums.length; index++){
            counts[nums[index]]++;
        }
        int current = 0;
        for(int number=1; number<=100; number++){
            for(int count=0; count<counts[number]; count++){
                nums[current] = number;
                current++;
            }
        }
    }
    public int water(int[] nums, int capacity){
        int current = capacity;
        int count = 0;
        for(int index=0; index<nums.length; index++){
            if(current >= nums[index]){
                current -= nums[index];
                count++;
            }else{
                current = capacity - nums[index];
                count += index * 2 + 1;
            }
        }
        return count;
    }
    public static void main(String[] argv){
        System.out.println(new CountingSort().water(new int[]{2,4,5,1,2},6));
    }
}
