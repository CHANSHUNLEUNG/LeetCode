package Questions.BitwiseOperation.question231;

public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return (n & -n) == n;
    }
}
