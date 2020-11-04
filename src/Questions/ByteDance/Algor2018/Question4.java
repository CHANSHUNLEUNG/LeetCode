package Questions.ByteDance.Algor2018;

import java.io.BufferedInputStream;
import java.util.*;

public class Question4 {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        String input = scanner.next();
        int number = scanner.nextInt();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int index = 0; index < input.length(); index++) {
            char current = input.charAt(index);
            List<Integer> temp = map.get(current);
            if (temp == null) {
                temp = new ArrayList<>();
                map.put(current, temp);
            }
            temp.add(index);
        }
        int max = 1;
        for (char key : map.keySet()) {
            List<Integer> position = map.get(key);
            for (int index = 0; index < position.size(); index++) {  // 以每一个字母为中心
                int steps[] = new int[position.size()];
                for (int compareIndex = 0; compareIndex < position.size(); compareIndex++) {
                    steps[compareIndex] = Math.abs(position.get(index) - position.get(compareIndex))
                            - Math.abs(compareIndex - index);
                }
                Arrays.sort(steps);
//                System.out.println("current:" + key + ",index:" + index);
//                for (int i = 0; i < steps.length; i++) {
//                    System.out.print(i + ":" + steps[i] + ", ");
//                }
//                System.out.println();
                int currentStep = 0;
                int currentLength = 0;
                for (int step : steps) {
                    if (currentStep + step > number) {
                        break;
                    } else {
                        currentStep += step;
                        currentLength++;
                        max = Math.max(currentLength, max);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
