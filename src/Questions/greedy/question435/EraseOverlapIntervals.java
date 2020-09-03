package Questions.greedy.question435;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Arrays.sort(intervals, Comparator.comparing(interval -> interval[1]));
        int count = 0, end = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] < end) {
                continue;
            }
            end = interval[1];
            count++;
        }
        return intervals.length - count;
    }

    public static void main(String[] argv) {
        int[][] test = new int[][]{{1, 3}, {2, 3}, {1, 2}};
        for (int[] item : test) {
            System.out.println(item[0] + "," + item[1]);
        }
        Arrays.sort(test, Comparator.comparing(item -> item[1]));
        for (int[] item : test) {
            System.out.println(item[0] + "," + item[1]);
        }
    }


}
