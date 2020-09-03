package Questions.greedy.question763;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        Set<Character> charSet = new HashSet<>();
        int count = 0;
        for (int index = 0; index < S.length(); index++) {
            //1. check last index and remove char in charSet
            //2. if charSet size 0, add new count, and continue
            //3. if charSet size not 0, add set.
            charSet.add(S.charAt(index));
            count++;
            if (S.lastIndexOf(S.charAt(index)) == index) {
                charSet.remove(S.charAt(index));
            }
            if (charSet.size() == 0) {
                result.add(count);
                count = 0;
            }
        }
        return result;
    }
}
