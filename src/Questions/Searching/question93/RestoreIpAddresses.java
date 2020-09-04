package Questions.Searching.question93;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        doCombination("", s, 1, result);
        return result;
    }

    private void doCombination(String prefix, String s, int position, List<String> result) {
        int prefixLength = prefix.length() + 1 - position;
        if (position == 5 && prefix.length() - 4 == s.length()) {
            result.add(prefix.substring(0, prefix.length() - 1));
            return;
        } else if (position > 4) {
            return;
        }

        for (int index = 0; index < Math.min(s.length() + position - 4 - prefixLength, 3); index++) {
            if (index > 0 && s.charAt(prefixLength) == '0') {
                return;
            }
            int value = Integer.valueOf(s.substring(prefixLength, prefixLength + index + 1));
            if (value < 0 || value > 255) {
                continue;
            }
            String nextPrefix = prefix + s.substring(prefixLength, prefixLength + index + 1) + ".";
            doCombination(nextPrefix, s, position + 1, result);
        }
    }

    public static void main(String[] argv) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        System.out.println(restoreIpAddresses.restoreIpAddresses("25525511135"));
    }
}
