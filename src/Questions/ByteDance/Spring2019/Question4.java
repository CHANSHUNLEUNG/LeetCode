package Questions.ByteDance.Spring2019;

import java.io.BufferedInputStream;
import java.util.*;

public class Question4 {
    public static void main(String[] argv){
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int cases = scanner.nextInt();
        int max = 0;
        for(int myCase=0; myCase<cases; myCase++){
            int frames = scanner.nextInt();

            Map<String, Integer> featureMap = new HashMap<>();

            for(int frame=0; frame<frames; frame++){
                int features = scanner.nextInt();
                Map<String, Integer> currentFrame = new HashMap<>();
                for(int feature=0; feature<features; feature++){
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    String current = x + "," + y;
//                    System.out.println(current);
                    if(currentFrame.containsKey(current)){
                        currentFrame.put(current, currentFrame.get(current) + 1);
                    }else if(featureMap.containsKey(current)){
                        currentFrame.put(current, featureMap.get(current)+1);
                    }else{
                        currentFrame.put(current,1);
                    }
                    max = Math.max(max, currentFrame.getOrDefault(current,0));
                }
                featureMap = currentFrame;
            }


        }
        System.out.println(max);
    }
}
