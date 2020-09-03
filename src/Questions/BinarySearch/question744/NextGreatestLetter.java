package Questions.BinarySearch.question744;

public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (letters[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left > letters.length - 1 ? letters[0] : letters[left];
    }

}
