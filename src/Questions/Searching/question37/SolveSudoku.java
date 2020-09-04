package Questions.Searching.question37;

public class SolveSudoku {
    public void solveSudoku(char[][] board) {
        doCombination(board, 0, 0);
    }

    private boolean doCombination(char[][] board, int startX, int startY) {
        while (startX < 9 && startY < 9) {
            if (board[startX][startY] == '.') {
                break;
            }
            if (startY == 8) {
                startY = 0;
                startX++;
            } else {
                startY++;
            }
        }
        if (startX >= 9) {
            return true;
        }
        for (int number = 1; number <= 9; number++) {
            if (isValid(startX, startY, number, board)) {
                board[startX][startY] = (char) ('0' + number);
                if (doCombination(board, startX, startY)) {
                    return true;
                }
            }
            board[startX][startY] = '.';
        }
        return false;
    }

    public boolean isValid(int x, int y, int number, char[][] board) {
        char target = (char) ('0' + number);
        for (int index = 0; index < board[0].length; index++) {
            if (target == board[x][index] || target == board[index][y]) {
                return false;
            }
        }
        int boardNumberX = x / 3, boardNumberY = y / 3;
        for (int indexX = boardNumberX * 3; indexX < (boardNumberX + 1) * 3; indexX++) {
            for (int indexY = boardNumberY * 3; indexY < (boardNumberY + 1) * 3; indexY++) {
                if (board[indexX][indexY] == target) {
                    return false;
                }
            }
        }

        return true;
    }
}
