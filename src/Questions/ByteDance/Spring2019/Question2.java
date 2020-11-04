package Questions.ByteDance.Spring2019;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int N = scanner.nextInt();
        int D = scanner.nextInt();
        int[] position = new int[N];
        for (int index = 0; index < N; index++) {
            position[index] = scanner.nextInt();
        }
        int start = 0, end = 0;
        long count = 0;
        while (end < N) {
            if (position[end] - position[start] <= D) {
                end++;
            } else {
                if(end - start - 1 > 0){
                    long number = end - start - 1;
                    count += ((number) * (number - 1) / 2) % 99997867;
                    count %= 99997867;
                }
                start++;
            }
        }
        for (int index = start; index < position.length; index++) {
            if(position.length - 1 - index > 0){
                long number = position.length - 1 - index;
                count += (number * (number-1) / 2) % 99997867;
                count %= 99997867;
            }
        }
        System.out.println(count);
    }
}
