package Questions.BitwiseOperation.question693;

public class HasAlternatingBits {
    public boolean hasAlternatingBits(int n) {
//        int check = n & -n;
//        if(check>2){
//            return false;
//        }
//        while (n != 0) {
//            if ((n & 0b11) != check) {
//                return false;
//            }
//            n >>>= 2;
//        }
//        return true;
        int a = (n ^ (n >>> 1));
        return (a & (a + 1)) == 0;
    }
}
