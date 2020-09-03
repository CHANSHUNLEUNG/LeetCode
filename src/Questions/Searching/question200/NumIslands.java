package Questions.Searching.question200;

public class NumIslands {
    private int[][] visited;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        this.grid = grid;
        visited = new int[grid.length][grid[0].length];
        int answer = 0;
        for (int firstDimension = 0; firstDimension < grid.length; firstDimension++) {
            for (int secondDimension = 0; secondDimension < grid[0].length; secondDimension++) {
//                1. if visited, answer remain the same
//                2. if not visited, dfs, and add it to answer.
                answer += dfs(firstDimension, secondDimension);
//                answer = Math.max(answer, dfs(firstDimension, secondDimension));
            }
        }
        return answer;
    }

    private int dfs(int firstDimension, int secondDimension) {
        if (firstDimension < 0 || firstDimension >= grid.length || secondDimension < 0 || secondDimension >= grid[0].length
                || visited[firstDimension][secondDimension] == 1 || grid[firstDimension][secondDimension] == '0') {
            return 0;
        }
        visited[firstDimension][secondDimension] = 1;
        dfs(firstDimension + 1, secondDimension);
        dfs(firstDimension - 1, secondDimension);
        dfs(firstDimension, secondDimension + 1);
        dfs(firstDimension, secondDimension - 1);
        return 1;
    }
}
