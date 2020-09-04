package Questions.Searching.question79;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exist {
    private char[][] board;
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        } else if (word == null || word.length() == 0) {
            return true;
        }
        this.board = board;
        visited = new int[board.length][board[0].length];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (checkExist(1, word, x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkExist(int currentLength, String word, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length ||
                board[x][y] != word.charAt(currentLength - 1) || visited[x][y] == 1) {
            return false;
        }
        if (currentLength == word.length()) {
            return true;
        }
        visited[x][y] = 1;

        boolean isExist = false;
        for (int[] direction : directions) {
            if(isExist = checkExist(currentLength + 1, word, x + direction[0], y + direction[1])){
             return true;
            }
        }
        visited[x][y] = 0;
        return isExist;
    }

    public static void main(String[] argv) {
        Exist exist = new Exist();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist.exist(board, "ABCB"));
    }
}
