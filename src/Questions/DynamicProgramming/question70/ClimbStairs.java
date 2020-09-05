package Questions.DynamicProgramming.question70;

public class ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int pre1 = 1, pre2 = 1;
        for (int index = 2; index <= n; index++) {
            int current = pre1 + pre2;
            pre2 = pre1;
            pre1 = current;
        }
        return pre1;
    }
}
