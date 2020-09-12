package Questions.BitwiseOperation.question190;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int answer = 0;
        for (int index = 0; index < 32; index++) {
            answer <<= 1;
            answer += n & 1;
            n >>>= 1;
        }
        return answer;
    }

    public static void main(String[] argv) {
        System.out.println(new ReverseBits().reverseBits(43261596));
    }
}
