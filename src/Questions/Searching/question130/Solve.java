package Questions.Searching.question130;

import java.util.*;

public class Solve {
    char[][] board;
    int[][] visited;

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        this.board = board;
        this.visited = new int[board.length][board[0].length];
        for (int x = 0; x < board.length; x++) {
            dfs(x, 0);
            dfs(x, board[0].length - 1);
        }
        for (int y = 0; y < board[0].length; y++) {
            dfs(0, y);
            dfs(board.length - 1, y);
        }
        for (int x = 1; x < board.length - 1; x++) {
            for (int y = 1; y < board[0].length - 1; y++) {
                if (visited[x][y] == 0 && board[x][y] == 'O') {
                    board[x][y] = 'X';
                }
            }
        }
    }

    private void dfs(int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] == 1 || board[x][y] == 'X') {
            return;
        }
        visited[x][y] = 1;
        dfs(x + 1, y);
        dfs(x - 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }
}
