package Questions.BinarySearch.question69;

public class MySqrt {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 1, right = x;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int sqrt = x / middle;
            if (sqrt == middle) {
                return middle;
            } else if (sqrt > middle) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return right;
    }
}
