package Questions.BitwiseOperation.question476;

public class FindComplement {
    public int findComplement(int num) {
        if(num == 0) {
            return 1;
        }
        return num ^ (Integer.highestOneBit(num << 1)) -1;
    }
    public static void main(String [] argv){
        System.out.println(Integer.highestOneBit(0));
    }
}
