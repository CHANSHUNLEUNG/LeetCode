package Questions.BitwiseOperation.question461;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int z = x ^ y;
        while (z != 0) {
//            if ((z & 1) == 1) {
//                count++;
//            }
//            z >>= 1;
            z &= z-1;
            count++;
        }
        return count;
    }

    public static void main(String[] argv) {
        System.out.println(8 & 1);
    }
}
