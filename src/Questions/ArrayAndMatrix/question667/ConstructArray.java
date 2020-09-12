package Questions.ArrayAndMatrix.question667;

import java.util.Arrays;

public class ConstructArray {
    public int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        answer[0] = 1;
        int last = 1;
        boolean up = true;
        for (int diff = k; diff >= 1; diff--) {
            int currentIndex = k - diff + 1;
            if (up) {
                answer[currentIndex] = last + diff;
                up = false;
            } else {
                answer[currentIndex] = last - diff;
                up = true;
            }
            last = answer[currentIndex];
        }
        for (int index = k + 1; index < n; index++) {
            answer[index] = index + 1;
        }
        return answer;
    }

    public static void main(String[] argv) {
        int[] answer = new ConstructArray().constructArray(9, 4);
        Arrays.stream(answer).forEach(System.out::print);
    }
}
