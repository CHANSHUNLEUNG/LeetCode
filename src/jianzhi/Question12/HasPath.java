package jianzhi.Question12;

public class HasPath {
    private static final int directions[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        String target = String.valueOf(str);
        boolean visited[][] = new boolean[rows][cols];
        char[][] pass = build(matrix, rows, cols);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(pass, visited, target, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] pass, boolean[][] visited, String target, int row, int col
            , int count) {
        if (count == target.length()) {
            return true;
        }
        if (row < 0 || row >= pass.length || col < 0 || col >= pass[0].length || visited[row][col] ||
                target.charAt(count) != pass[row][col]) {
            return false;
        }

        visited[row][col] = true;
        for (int[] direction : directions) {
            int x = row + direction[0];
            int y = col + direction[1];
            if(dfs(pass, visited, target, x, y, count + 1)){
                return true;
            }
        }
        visited[row][col] = false;

        return false;
    }

    private char[][] build(char[] matrix, int rows, int cols) {
        char[][] answer = new char[rows][cols];
        int pointer = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                answer[row][col] = matrix[pointer++];
            }
        }
        return answer;
    }

    public static void main(String[] argv) {
        System.out.println(new HasPath().hasPath("ABCESFCSADEE".toCharArray(), 3, 4, "ABCCED".toCharArray()));
    }
}
