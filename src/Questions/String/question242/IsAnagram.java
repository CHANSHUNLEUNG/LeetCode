package Questions.String.question242;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int[] counts = new int[26];
        for (char character : s.toCharArray()) {
            counts[character - 'a']++;
        }
        for (char character : t.toCharArray()) {
            counts[character - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
