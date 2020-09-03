package Questions.Searching.question547;

import java.util.ArrayList;
import java.util.List;

public class FindCircleNum {
    private int[][] M;
    private int[] visited;

    public int findCircleNum(int[][] M) {
        this.M = M;
        this.visited = new int[M.length];
        int connectedComponent = 0;
        for (int firstDimension = 0; firstDimension < M.length; firstDimension++) {
            if (visited[firstDimension] == 0) {
                connectedComponent++;
                dfs(firstDimension);
            }
        }
        return connectedComponent;
    }

    private void dfs(int firstDimension) {
        visited[firstDimension] = 1;
        List<Integer> directions = new ArrayList<>();
        for (int relationIndex = 0; relationIndex < M[firstDimension].length; relationIndex++) {
            if (visited[relationIndex] == 0 && M[firstDimension][relationIndex] == 1) {
                directions.add(relationIndex);
            }
        }
        if (directions.size() == 0) {
            return;
        }
        for (int direction : directions) {
            dfs(direction);
        }
    }
}
