package Questions.BinarySearch.question278;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 0, right = n;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int middle) {
        return false;
    }

}
