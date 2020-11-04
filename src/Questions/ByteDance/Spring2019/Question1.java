package Questions.ByteDance.Spring2019;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] argv){
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int number = scanner.nextInt();
        for(int index=0; index<number; index++){
            solve(scanner.next());
        }
        scanner.close();

    }

    private static void solve(String next) {
        if(next.length()<=2){
            System.out.println(next);
            return;
        }
        char first = next.charAt(0);
        char second = next.charAt(1);
        char third = next.charAt(2);
        StringBuilder stringBuilder = new StringBuilder();
        if(first == second && second == third){
            stringBuilder.append(first).append(second);
        }else{
            stringBuilder.append(first).append(second).append(third);
        }
        for(int index=3; index<next.length(); index++){
            char current = next.charAt(index);
            if(first == second && third == current){
                continue;
            }
            if(second == third && third == current){
                continue;
            }
            stringBuilder.append(current);
            first = second;
            second = third;
            third = current;
        }
        System.out.println(stringBuilder.toString());
    }
}
