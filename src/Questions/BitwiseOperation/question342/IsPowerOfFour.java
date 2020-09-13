package Questions.BitwiseOperation.question342;

public class IsPowerOfFour {
    public boolean isPowerOfFour(int num) {
//        if (num < 4 && num != 1) {
//            return false;
//        }
//        while (num >= 4) {
//            if (num % 4 != 0) {
//                return false;
//            }
//            num /= 4;
//        }
//        return num == 1;
        if(Integer.bitCount(num) != 1){
            return false;
        }
        while(num !=0){
            if((num & 0b11) == 2){
                return false;
            }
            num>>>=2;
        }
        return true;
    }
}
