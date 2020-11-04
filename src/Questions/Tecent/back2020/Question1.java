package Questions.Tecent.back2020;


import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Question1 {
    public static void main(String[] argv){
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        String input = scanner.next();
        Stack<String> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(char current : input.toCharArray()){
            if(stack.isEmpty() && current != '[' && current != ']' && current != '|'){
                stringBuilder.append(current);
                continue;
            }
            if(current != ']'){
                stack.push(String.valueOf(current));
            }else{
                String temp = parse(stack);
                if(stack.isEmpty()){
                    stringBuilder.append(temp);
                }else{
                    stack.push(temp);
                }
            }
        }
        System.out.println(stringBuilder.toString());
    }
    public static String parse(Stack<String> stack){
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder repeatedReverseString = new StringBuilder();
        while(!stack.isEmpty() && !stack.peek().equals("|")){
            String temp = new StringBuilder(stack.pop()).reverse().toString();
            repeatedReverseString.append(temp);
        }
        String repeatedString = repeatedReverseString.reverse().toString();
        stack.pop();
        StringBuilder reverseNumber = new StringBuilder();
        while(!stack.isEmpty() && !stack.peek().equals("[")){
            reverseNumber.append(stack.pop());
        }
        int times = Integer.parseInt(reverseNumber.reverse().toString());
        stack.pop();
        for(int index=0; index<times; index++){
            stringBuilder.append(repeatedString);
        }
        return stringBuilder.toString();
    }
}
