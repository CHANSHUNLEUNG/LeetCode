package Questions.Searching.question695;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxAreaOfIsland {
    private int[][] visited;
    private int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        this.grid = grid;
        visited = new int[grid.length][grid[0].length];
        int count = 0;
        for (int firstDimension = 0; firstDimension < grid.length; firstDimension++) {
            for (int secondDimension = 0; secondDimension < grid[0].length; secondDimension++) {
                count = Math.max(count, dfs(firstDimension, secondDimension));
            }
        }
        return count;
    }

    private int dfs(int firstDimension, int secondDimension) {
        if (firstDimension < 0 || firstDimension >= grid.length || secondDimension < 0 || secondDimension >= grid[0].length ||
                visited[firstDimension][secondDimension] == 1 || grid[firstDimension][secondDimension] == 0) {
            return 0;
        }
        visited[firstDimension][secondDimension] = 1;
        return (1 + dfs(firstDimension + 1, secondDimension) + dfs(firstDimension - 1, secondDimension)
                + dfs(firstDimension, secondDimension + 1) + dfs(firstDimension, secondDimension - 1));
    }


}
