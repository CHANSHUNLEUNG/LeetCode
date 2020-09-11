package Questions.ArrayAndMatrix.question240;

public class SearchMatrix {
    //    public boolean searchMatrix(int[][] matrix, int target) {
//        if(matrix == null){
//            return false;
//        }
//        for(int row=0;row<matrix.length;row++){
//            for(int col=0;col<matrix[0].length;col++){
//                if(matrix[row][col] == target) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
