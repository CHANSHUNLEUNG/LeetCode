package Questions.TwoPointers.question633;

public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int cSqrt = (int) Math.sqrt(c);
        int start=0;
        while(start <= cSqrt){
            if(Math.pow(start,2) + Math.pow(cSqrt,2) > c){
                cSqrt--;
            }else if(Math.pow(start,2) + Math.pow(cSqrt,2) < c){
                start++;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] argv) {
        System.out.println((int) Math.sqrt(101));
    }
}
