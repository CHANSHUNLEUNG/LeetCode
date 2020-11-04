package Questions.Concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Clover {
    public static void main(String[] argv) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(bf.readLine());
        for (int index = 0; index < testcases; index++) {
            String input = bf.readLine();
            System.out.println(reverse(input));
        }
        bf.close();
    }

    private static String reverse(String input) {
        if (input == null) {
            return "";
        }
        input = input.trim();
        String[] words = input.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        if (words.length <= 2) {
            for (int index = 0; index < words.length; index++) {
                if (index == words.length - 1) {
                    stringBuilder.append(words[index]);
                } else {
                    stringBuilder.append(words[index] + " ");
                }
            }
            return stringBuilder.toString();
        }

        for (int index = words.length - 2; index >= 1; index--) {
            stringBuilder.append(words[index] + " ");
        }

        stringBuilder.append(words[words.length - 1]);
        return words[0] + " " + stringBuilder.toString();
    }
}
