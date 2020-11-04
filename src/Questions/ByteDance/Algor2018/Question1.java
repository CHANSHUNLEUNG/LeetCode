package Questions.ByteDance.Algor2018;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Question1 {
    public static int test = 10;
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int number = scanner.nextInt();
        int position[][] = new int[number][2];
        for (int index = 0; index < number; index++) {
            position[index][0] = scanner.nextInt();
            position[index][1] = scanner.nextInt();
        }
        Arrays.sort(position, (x, y) -> x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]);
        List<List<Integer>> answer = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int last = Integer.MIN_VALUE;
        for (int index = number - 1; index >= 0; index--) {
            if (index != last) {
                if (position[index][1] > max) {
                    max = position[index][1];
                    answer.add(new ArrayList<>(Arrays.asList(position[index][0], position[index][1])));
//                    System.out.println(max);
                }
                last = index;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = answer.size() - 1; index >= 0; index--) {
            stringBuilder.append(answer.get(index).get(0) + " " + answer.get(index).get(1) + "\n");
        }
        System.out.println(stringBuilder.toString());
    }
}
