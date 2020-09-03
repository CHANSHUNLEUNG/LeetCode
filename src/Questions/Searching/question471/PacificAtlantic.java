package Questions.Searching.question471;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PacificAtlantic {
    private int[][] pacific;
    private int[][] atlantic;
    private int[][] matrix;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        this.matrix = matrix;
        pacific = new int[matrix.length][matrix[0].length];
        atlantic = new int[matrix.length][matrix[0].length];
        for (int x = 0; x < matrix.length; x++) {
            dfs(x, 0, pacific, Integer.MIN_VALUE);
            dfs(x, matrix[0].length - 1, atlantic, Integer.MIN_VALUE);
        }
        for (int y = 0; y < matrix[0].length; y++) {
            dfs(0, y, pacific, Integer.MIN_VALUE);
            dfs(matrix.length - 1, y, atlantic, Integer.MIN_VALUE);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (pacific[x][y] == 1 && atlantic[x][y] == 1) {
                    result.add(Arrays.asList(x, y));
                }
            }
        }
        return result;
    }

    private void dfs(int x, int y, int[][] ocean, int prev) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length
                || prev > matrix[x][y] || ocean[x][y] == 1) {
            return;
        }
        ocean[x][y] = 1;
        dfs(x + 1, y, ocean, matrix[x][y]);
        dfs(x - 1, y, ocean, matrix[x][y]);
        dfs(x, y + 1, ocean, matrix[x][y]);
        dfs(x, y - 1, ocean, matrix[x][y]);
    }
}
