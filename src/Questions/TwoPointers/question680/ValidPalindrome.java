package Questions.TwoPointers.question680;

public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        if (s.length() == 1) return true;
        int start = 0, end = s.length() - 1;
        while(start <= end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                return isPalidrome(s, start+1,end) || isPalidrome(s,start,end-1);
            }
        }
        return true;
    }

    private boolean isPalidrome(String s, int start, int end) {
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

}
