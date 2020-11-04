package Questions.ByteDance.Test2018;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int numbers = scanner.nextInt();
        int m = scanner.nextInt();
        int colors = scanner.nextInt();
        int lastOcc[] = new int[colors + 1];
        Arrays.fill(lastOcc, -1);
        int count = 0;
        boolean[] dup = new boolean[colors + 1];
        for (int index = 0; index < numbers; index++) {
            int number = scanner.nextInt();
            boolean[] visited = new boolean[colors + 1];
            for (int colorIndex = 0; colorIndex < number; colorIndex++) {
                int current = scanner.nextInt();
                if (visited[current] || current == 0) {
                    continue;
                }
                visited[current] = true;
                if (lastOcc[current] != -1 && index + 1 - lastOcc[current] <=m && !dup[current]
                || number == 1 && !dup[current]) {
                    dup[current] = true;
//                    System.out.println(current);
                    count++;
                }
                lastOcc[current] = index;
            }
//            System.out.println();
        }
        System.out.println(count);

    }
}
