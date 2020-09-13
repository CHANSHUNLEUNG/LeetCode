package Questions.BitwiseOperation.question318;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaxProduct {
    public int maxProduct(String[] words) {

        int[] map = new int[words.length];
        for (int index = 0; index < words.length; index++) {
            for (char character : words[index].toCharArray()) {
                map[index] |= 1 << (character - 'a');
            }
        }
        int max = 0;
        for (int index = 0; index < words.length; index++) {
            for (int compareIndex = index; compareIndex < words.length; compareIndex++) {
                if ((map[index] & map[compareIndex]) == 0) {
                    max = Math.max(max, words[index].length() * words[compareIndex].length());
                }
            }
        }
        return max;
    }

    public static void main(String[] argv) {
        System.out.println("".contains(""));
    }
}
