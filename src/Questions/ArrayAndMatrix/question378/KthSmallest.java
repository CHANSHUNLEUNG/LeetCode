package Questions.ArrayAndMatrix.question378;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null) {
            return 0;
        }
        List<Integer> numberList = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                numberList.add(matrix[row][col]);
            }
        }
        Collections.sort(numberList);
        return numberList.get(k - 1);
    }
}
