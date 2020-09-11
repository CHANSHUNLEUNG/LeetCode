package Questions.ArrayAndMatrix.question378;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null) {
            return 0;
        }
        int large = matrix.length * matrix[0].length - k + 1;
    }
}
