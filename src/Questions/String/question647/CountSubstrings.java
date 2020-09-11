package Questions.String.question647;

public class CountSubstrings {
    //    public int countSubstrings(String s) {
//        int count = 0;
//        for (int index = 0; index < s.length(); index++) {
//            for (int compareIndex = index + 1; compareIndex <= s.length(); compareIndex++) {
//                if (isPalidrome(s.substring(index, compareIndex))) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    private boolean isPalidrome(String substring) {
//        int start =0 ,end=substring.length()-1;
//        while(start < end){
//            if(substring.charAt(start)!= substring.charAt(end)){
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }
    private int count = 0;

    public int countSubstrings(String s) {

        for (int index = 0; index < s.length(); index++) {
            extend(s, index, index);
            extend(s, index, index + 1);

        }
        return this.count;
    }

    private void extend(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            this.count++;
            start--;
            end++;
        }
    }

    public static void main(String[] argv) {
        System.out.println("test".substring(0, 4));
    }
}
