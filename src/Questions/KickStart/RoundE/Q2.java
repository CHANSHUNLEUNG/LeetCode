package Questions.KickStart.RoundE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Q2 {
    public static void main(String[] argv) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testNumber = Integer.parseInt(bf.readLine());
        for (int index = 1; index <= testNumber; index++) {
            String[] input = bf.readLine().split(" ");
            int num = Integer.parseInt(input[0]);
            int A = Integer.parseInt(input[1]);
            int B = Integer.parseInt(input[2]);
            int C = Integer.parseInt(input[3]);
            String answer = solve(num, A, B, C);
            System.out.println("Case #" + index + ": " + answer);
        }
        bf.close();
    }

    private static String solve(int num, int a, int b, int c) {
        int unvisible = num + c - a - b;
        if (unvisible < 0 || num > 1 && a == b && b == c && c == 1) {
            return "IMPOSSIBLE";
        }
        int left = a - c;
        int right = b - c;
        int answer[] = new int[num];
        int current = 0;
        for (int index = 0; index < left; index++) {
            answer[current] = unvisible + 1;
            current++;
        }
        if(a == c && c == 1 || c > 1){
            answer[current] = num;
            current++;
        }
        for (int index = 0; index < unvisible; index++) {
            answer[current] = index + 1;
            current++;
        }
        if(a > c && c == 1){
            answer[current] = num;
            current++;
        }

        for (int index = 0; index < c-1; index++) {
            answer[current] = num;
            current++;
        }

        for (int index = 0; index < right; index++) {
            answer[current] = unvisible + 1;
            current++;
        }
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < answer.length; index++) {
            if (index != answer.length - 1) {
                sb.append(answer[index] + " ");
            } else {
                sb.append(answer[index]);
            }
        }
        return sb.toString();
    }
}
