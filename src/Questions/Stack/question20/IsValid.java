package Questions.Stack.question20;

import java.util.Stack;

public class IsValid {
    public boolean isValid(String s) {
        int big = 0, middle = 0, small = 0;
        Stack<Character> stack = new Stack<>();
        for (int index = s.length() - 1; index >= 0; index--) {
            char current = s.charAt(index);
            if (current == '}' || current == ']' || current == ')') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) return false;
                char last = stack.pop();
                if (current == '(' && last != ')') return false;
                if (current == '[' && last != ']') return false;
                if (current == '{' && last != '}') return false;
            }
        }
        return stack.isEmpty();
    }
}
