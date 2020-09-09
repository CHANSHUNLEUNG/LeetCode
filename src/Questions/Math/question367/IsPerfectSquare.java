package Questions.Math.question367;

public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int minus = 1;
        while (num > 0) {
            num -= minus;
            minus += 2;
        }
        return num == 0;
    }
}
