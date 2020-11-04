package Questions.ByteDance.Test2018;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int users = scanner.nextInt();
        int interest[][] = new int[users][2];
        for (int index = 0; index < users; index++) {
            interest[index][0] = index + 1;
            interest[index][1] = scanner.nextInt();
        }
        Arrays.sort(interest, (x, y) -> x[1] - y[1]);
        int cases = scanner.nextInt();
        for (int index = 0; index < cases; index++) {
            int leftInterval = scanner.nextInt();
            int rightInterval = scanner.nextInt();
            int k = scanner.nextInt();
            int left = 0, right = users-1;
            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (interest[middle][1] >= k) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            if (interest[left][1] != k) {
                System.out.println(0);
                continue;
            }
            int start = left;
            left = 0;
            right = users-1;
            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (interest[middle][1] <= k) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            int count = 0;
            int end = right;
            for (int positionIndex = start; positionIndex <= end; positionIndex++) {
                if (interest[positionIndex][0] >= leftInterval && interest[positionIndex][0] <= rightInterval) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
