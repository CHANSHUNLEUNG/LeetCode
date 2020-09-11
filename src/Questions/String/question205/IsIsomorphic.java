package Questions.String.question205;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] sIndex = new int[256];
        int[] tIndex = new int[256];
        Arrays.fill(sIndex, -1);
        Arrays.fill(tIndex, -1);
        for (int index = 0; index < s.length(); index++) {
            if (sIndex[s.charAt(index)] != tIndex[t.charAt(index)]) {
                return false;
            }
            sIndex[s.charAt(index)] = index;
            tIndex[t.charAt(index)] = index;
        }
        return true;
    }

    public static void main(String[] argv) {
        System.out.println(new IsIsomorphic().isIsomorphic("ab", "aa"));
    }
}
