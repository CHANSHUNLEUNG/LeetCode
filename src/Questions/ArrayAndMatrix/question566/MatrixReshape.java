package Questions.ArrayAndMatrix.question566;

public class MatrixReshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null) {
            return null;
        }
        if (r * c != nums.length * nums[0].length) {
            return nums;
        }
        int[][] answer = new int[r][c];
        int index = 0;
        for (int row = 0; row < nums.length; row++) {
            for (int col = 0; col < nums[0].length; col++) {
                answer[index / c][index % c] = nums[row][col];
                index++;
            }
        }
        return answer;
    }
}
