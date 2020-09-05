package Questions.DynamicProgramming.question62;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] possibleWays = new int[m];
        for (int xIndex = 0; xIndex < n; xIndex++) {
            for (int yIndex = 0; yIndex < m; yIndex++) {
                if (xIndex == 0) {
                    possibleWays[yIndex] = 1;
                } else if (yIndex == 0) {
                    possibleWays[yIndex] = 1;
                } else {
                    possibleWays[yIndex] = possibleWays[yIndex] + possibleWays[yIndex - 1];
                }
            }
        }
        return possibleWays[m - 1];
    }
}
