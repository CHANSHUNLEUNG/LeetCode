package Questions.ArrayAndMatrix.question766;

public class IsToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            int currentRow = 1, currentCol = col + 1;
            while (currentRow < matrix.length && currentCol < matrix[0].length) {
                if (matrix[currentRow][currentCol] != matrix[currentRow - 1][currentCol - 1]) {
                    return false;
                }
                currentRow++;
                currentCol++;
            }
        }
        for (int row = 1; row < matrix.length; row++) {
            int currentRow = row + 1, currentCol = 1;
            while (currentRow < matrix.length && currentCol < matrix[0].length) {
                if (matrix[currentRow][currentCol] != matrix[currentRow - 1][currentCol - 1]) {
                    return false;
                }
                currentRow++;
                currentCol++;
            }
        }
        return true;
    }
}
