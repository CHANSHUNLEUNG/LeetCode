package Study.RabbitMQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Answer {
    public static void main(String[] argv) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numbers = Integer.parseInt(bf.readLine());
        for(int index=0; index<numbers; index++){
            String input = bf.readLine();
            System.out.println(solve(input));
        }
        bf.close();
    }

    private static String solve(String input) {
        if(input.length() <= 2){
            return input;
        }
        char first = input.charAt(0);
        char second = input.charAt(1);
        char third = input.charAt(2);
        StringBuilder stringBuilder = new StringBuilder();
        if(first == second && second == third){
            stringBuilder.append(first).append(second);
        }else{
            stringBuilder.append(first).append(second).append(third);
        }
        for(int index=3; index<input.length(); index++){
            char current = input.charAt(index);
            if(second == third && third == current){
                continue;
            }
            if(first == second && third == current){
                continue;
            }
            first = second;
            second = third;
            third = current;
            stringBuilder.append(current);
        }
        return stringBuilder.toString();
    }
}
