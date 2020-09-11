package Questions.String.question9;

public class IsPalindrome {
    //    public boolean isPalindrome(int x) {
//        if (x < 0) {
//            return false;
//        }
//        String xString = String.valueOf(x);
//        int start = 0, end = xString.length() - 1;
//        while (start < end) {
//            if (xString.charAt(start) != xString.charAt(end)) {
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int right = 0;
        while (x > right) {
            right = right * 10 + x % 10;
            x /= 10;
        }
        return x == right || x == right / 10;
    }
}
