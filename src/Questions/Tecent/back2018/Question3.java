package Questions.Tecent.back2018;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Question3 {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int day = scanner.nextInt();
        int number = scanner.nextInt();
        int left = 1, right = number;
        while (left <= right) {
            int cho = number;
            int middle = left + (right - left) / 2;
//            System.out.println(middle);
            int today = middle;
            for (int index = 0; index < day; index++) {
                cho -= today;
                today = today == 1 ? 1 : (int) Math.ceil(today / 2.0);
            }
            if(cho < 0){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }
        System.out.println(right);
    }
}
