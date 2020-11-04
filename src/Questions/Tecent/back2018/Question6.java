package Questions.Tecent.back2018;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Question6 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        char grid[][] = new char[N][M];
        for (int index = 0; index < N; index++) {
            grid[index] = scanner.next().toCharArray();
        }
        char ori[][] = new char[N][M];
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                ori[row][col] = 'X';
            }
        }
        backTracking(grid, ori, 0, 0, 0);
        System.out.println(min);
    }

    private static void backTracking(char[][] grid, char[][] ori, int row, int col, int count) {
        while (row < grid.length) {
            if (grid[row][col] == ori[row][col]) {
                if (col == grid[0].length - 1) {
                    row++;
                    col = 0;
                } else {
                    col++;
                }
            } else {
                break;
            }
        }
        if (row >= grid.length) {
            min = Math.min(min, count);
            return;
        }


    }
}
