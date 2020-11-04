package Questions.ByteDance.Spring2019;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Question3 {
    private static Set<Integer> answer = new HashSet<>();
    public static void main(String[] argv){
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int[] nums = new int[10];
        for(int index=0; index<13; index++){
            nums[scanner.nextInt()]++;
        }
        for(int index=1; index<=9; index++){
            if(nums[index] == 4){
                continue;
            }
            nums[index]++;
//            System.out.println("-------选牌" + index);
            for(int quezi=1; quezi<=9; quezi++) {
                if(nums[quezi]<2){
                    continue;
                }
                nums[quezi]-=2;
                kezi(nums, 0, index);
                nums[quezi]+=2;
            }
            nums[index]--;
        }
        if(answer.size() == 0){
            System.out.println(0);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int num : answer){
            stringBuilder.append(num + " ");
        }
        System.out.println(stringBuilder.toString().substring(0, stringBuilder.length()-1));

    }

    private static void kezi(int[] nums, int kezi, int xuanpai) {
        for(int index=1; index<=9; index++){
            if(nums[index]>=3){
                nums[index] -= 3;
                kezi(nums, kezi+1, xuanpai);
                nums[index] += 3;
            }
            //shunzi
            int shunzi = 0;
            int[] temp = Arrays.copyOf(nums,nums.length);
            for(int number=3; number<=9; number++){
                while(temp[number] > 0 && temp[number-1] > 0 && temp[number-2] > 0){
                    shunzi++;
                    temp[number]--;
                    temp[number-1]--;
                    temp[number-2]--;
                }
            }
//            System.out.println("当前刻子:" + index + ", kezi:"+kezi + ",shunzi:" + shunzi);
            if(shunzi + kezi == 4){
                answer.add(xuanpai);
            }
        }
    }
}
