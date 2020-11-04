package Study.RabbitMQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question3 {
    public static void main(String[] argv) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] info = bf.readLine().split(" ");
        int[] nums = new int[13];
        for (int index = 0; index < nums.length; index++) {
            nums[index] = Integer.parseInt(info[index]);
        }
        solve(nums);
        bf.close();
    }

    private static void solve(int[] nums) {
        int[] counts = new int[37];
        for (int num : nums) {
            counts[num]++;
        }
        List<Integer> answer = new ArrayList<>();
        for (int num = 1; num <= 9; num++) {
            if(counts[num] == 4){
                continue;
            }
            int[] temp = Arrays.copyOf(counts,counts.length);
            temp[num]++;
            List<Integer> possibleBird = new ArrayList<>();
            for(int index=0; index<temp.length; index++){
                if(temp[index] >=2){
                    possibleBird.add(index);
                    System.out.print(index+" ");
                }
            }
            System.out.println();

            for(int bird : possibleBird){
                temp[bird] -= 2;
                //kezi
                int kezi = 0;
                for(int index=0; index<temp.length; index++){
                    if(temp[index] == 3){
                        kezi++;
                    }
                }
                if(kezi == 4){
                    answer.add(num);
                    break;
                }
                //shunzi
                int[] shunziTemp = Arrays.copyOf(temp,temp.length);
                int shunzi = 0;
                for(int index=2; index<shunziTemp.length; index++){
                    while(shunziTemp[index] > 0 && shunziTemp[index-1] > 0 && shunziTemp[index-2]>0){
                        shunzi++;
                        shunziTemp[index]--;
                        shunziTemp[index-1]--;
                        shunziTemp[index-2]--;
                    }
                }
                System.out.println("shunzi:" +  shunzi);
                if(shunzi == 4){
                    answer.add(num);
                    break;
                }
                temp[bird] += 2;
            }
        }
        if(answer.size() == 0){
            System.out.println(0);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : answer) {
            stringBuilder.append(num + " ");
        }
        System.out.println(stringBuilder.toString().substring(0, stringBuilder.length() - 1));
        return;
    }
}
