package Questions.greedy.question455;

import java.util.Arrays;

public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        if(s == null || g == null){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int sIndex = 0, gIndex = 0; sIndex < s.length && gIndex < g.length; sIndex++) {
            if (s[sIndex] >= g[gIndex]) {
                count++;
                gIndex++;
            }
        }
        return count;
    }
}
