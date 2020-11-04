package Questions.ArrayAndMatrix.question378;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallest {
//    public int kthSmallest(int[][] matrix, int k) {
//        if (matrix == null) {
//            return 0;
//        }
//        List<Integer> numberList = new ArrayList<>();
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[0].length; col++) {
//                numberList.add(matrix[row][col]);
//            }
//        }
//        Collections.sort(numberList);
//        return numberList.get(k - 1);
//    }
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[m - 1][n - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    if(mid == 62){
                        System.out.println(matrix[i][j]);
                    }
                    cnt++;
                }
            }
            if (cnt < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    public static void main(String[] argv){
        System.out.println(0^10);
        System.out.println(Integer.toBinaryString(-1));
    }
}
