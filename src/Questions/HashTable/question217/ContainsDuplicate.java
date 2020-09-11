package Questions.HashTable.question217;

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) return true;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                System.out.println(num);
                return true;
            }
            hashSet.add(num);
        }
        return false;
    }
}
