package Questions.greedy.question452;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int end = points[0][1];
        int count = 1;
        for (int[] point : points) {
            if (point[0] <= end) {
                continue;
            }
            end = point[1];
            count++;
        }
        return count;
    }
}
