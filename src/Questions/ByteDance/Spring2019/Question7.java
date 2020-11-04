package Questions.ByteDance.Spring2019;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class Question7 {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int data = scanner.nextInt();
        int max = 0;
        int[] position = new int[data];
        for (int index = 0; index < data; index++) {
            position[index] = scanner.nextInt();
            max = Math.max(max, position[index]);
        }
        long min = Integer.MAX_VALUE;
        for (int backup = max; backup >= 0; backup--) {
            BigInteger energy = new BigInteger(String.valueOf(backup));
            boolean can = true;
            for (int index = 0; index < position.length; index++) {
                energy = energy.add(energy);
                energy = energy.subtract(new BigInteger(String.valueOf(position[index])));
                if(energy.compareTo(new BigInteger(String.valueOf(max))) > 0){
                    break;
                }
                if (energy.compareTo(new BigInteger("0")) < 0) {
                    can = false;
                    break;
                }
            }
            if(can){
                min = Math.min(min, backup);
            }
        }
        System.out.println(min);
    }
}
