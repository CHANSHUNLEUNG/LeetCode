package Questions.Searching.question1091;

import java.security.KeyPair;
import java.util.*;

public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0] == 1
                || grid[grid.length - 1][grid.length - 1] == 1) {
            return -1;
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(0, 0));
        int iterationSize = 1, distance = 0;
        int visited[][] = new int[grid.length][grid.length];
        while (!queue.isEmpty()) {
            distance++;
            for (int index = 0; index < iterationSize; index++) {
                List<Integer> current = queue.poll();
                int x = current.get(0), y = current.get(1);
                visited[x][y] = 1;
                if (x == grid.length - 1 && y == grid.length - 1) {
                    return distance;
                }

                safeAddNext(grid, visited, queue, x - 1, y - 1);
                safeAddNext(grid, visited, queue, x, y - 1);
                safeAddNext(grid, visited, queue, x + 1, y - 1);
                safeAddNext(grid, visited, queue, x - 1, y);
                safeAddNext(grid, visited, queue, x + 1, y);
                safeAddNext(grid, visited, queue, x - 1, y + 1);
                safeAddNext(grid, visited, queue, x, y + 1);
                safeAddNext(grid, visited, queue, x + 1, y + 1);
            }
            iterationSize = queue.size();
        }
        return -1;
    }

    private void safeAddNext(int[][] grid, int[][] visited, Queue<List<Integer>> queue, int x, int y) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid.length && grid[x][y] == 0 && visited[x][y] == 0) {
            visited[x][y] = 1;
            queue.offer(Arrays.asList(x, y));
        }
    }

    public static void main(String[] argv) {
        int[][] grid = new int[3][3];
        grid[0][0] = 0;
        grid[0][1] = 0;
        grid[0][2] = 0;
        grid[1][0] = 1;
        grid[1][1] = 1;
        grid[1][2] = 0;
        grid[2][0] = 1;
        grid[2][1] = 1;
        grid[2][2] = 0;
        ShortestPathBinaryMatrix test = new ShortestPathBinaryMatrix();
        System.out.println(test.shortestPathBinaryMatrix(grid));
    }
}
