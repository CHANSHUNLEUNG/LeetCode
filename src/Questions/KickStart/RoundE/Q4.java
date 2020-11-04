package Questions.KickStart.RoundE;

import java.util.*;

public class Q4 {
    //    __*
//    _***
//            *****
//    _***
//    __*
    public void print(int number) {
        for (int index = 0; index < number - 1; index++) {
            int space = number - index - 1;
            int star = index * 2 + 1;
            StringBuilder sb = new StringBuilder();
            for (int spaceCount = 0; spaceCount < space; spaceCount++) {
                sb.append("_");
            }
            for (int starCount = 0; starCount < star; starCount++) {
                sb.append("*");
            }
            System.out.println(sb.toString());
        }

        for (int index = 0; index < number * 2 - 1; index++) {
            System.out.print("*");
        }
        System.out.println();
        for (int index = 0; index < number - 1; index++) {
            int space = index + 1;
            int star = number * 2 - 3 - index * 2;
            StringBuilder sb = new StringBuilder();
            for (int spaceCount = 0; spaceCount < space; spaceCount++) {
                sb.append("_");
            }
            for (int starCount = 0; starCount < star; starCount++) {
                sb.append("*");
            }
            System.out.println(sb.toString());
        }
    }

    public int evalRPN(String[] tokens){
        if(tokens == null){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        boolean isFirst = true;
        int current = 0;
        for(String token : tokens){
            char first = token.charAt(0);
            if(first == '+' || first == '-' || first == '*' || first == '/'){
                if(isFirst ){
                    isFirst = false;
                    current = stack.pop();
                }
                if(first == '+') current = stack.pop() + current;
                if(first == '-') current = stack.pop() - current;
                if(first == '*') current = stack.pop() * current;
                if(first == '/') current = stack.pop() / current;
                System.out.println("current:" + current);
                System.out.println("token:" + token);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return current;
    }




    public static void main(String[] argv) {
        List<Integer> test = new ArrayList<>(Arrays.asList(1,2,4));
        System.out.println(Collections.binarySearch(test,3));
        System.out.println(Collections.binarySearch(test,1));
        System.out.println(Collections.binarySearch(test,5));
        System.out.println(Collections.binarySearch(test,-10));
    }
}
