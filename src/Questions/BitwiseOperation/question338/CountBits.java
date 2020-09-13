package Questions.BitwiseOperation.question338;

public class CountBits {
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        int[] answer = new int[num + 1];
        answer[1] = 1;
        int last = 0;
        int next = 2;
        for (int index = 2; index <= num; index++) {
            if (index == next) {
                last = next;
                next = next * 2;
            }
            answer[index] = 1 + answer[index - last];
        }
        return answer;
    }
}
