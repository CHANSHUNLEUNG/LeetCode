package Questions.ArrayAndMatrix.question769;

import java.util.Arrays;

public class MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int count = 0;
        int max = 0;
        for (int index = 0; index < arr.length; index++) {
            max = Math.max(max, arr[index]);
            if (max == index) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] argv) {
        System.out.println(new MaxChunksToSorted().maxChunksToSorted(new int[]{1, 0, 2, 3, 4, 6, 5, 0}));
    }
}
