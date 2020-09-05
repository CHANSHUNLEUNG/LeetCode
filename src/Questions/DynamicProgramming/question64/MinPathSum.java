package Questions.DynamicProgramming.question64;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] minimumSum = new int[grid.length][grid[0].length];
        for (int yIndex = 0; yIndex < grid[0].length; yIndex++) {
            minimumSum[0][yIndex] = (yIndex == 0) ? grid[0][yIndex] : minimumSum[0][yIndex - 1] + grid[0][yIndex];
        }
        for (int xIndex = 1; xIndex < grid.length; xIndex++) {
            minimumSum[xIndex][0] = minimumSum[xIndex - 1][0] + grid[xIndex][0];
        }
        for (int xIndex = 1; xIndex < grid.length; xIndex++) {
            for (int yIndex = 1; yIndex < grid[0].length; yIndex++) {
                minimumSum[xIndex][yIndex] = Math.min(minimumSum[xIndex - 1][yIndex], minimumSum[xIndex][yIndex - 1]) + grid[xIndex][yIndex];

            }
        }
        return minimumSum[grid.length - 1][grid[0].length - 1];
    }
}
