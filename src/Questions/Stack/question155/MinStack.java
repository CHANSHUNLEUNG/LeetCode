package Questions.Stack.question155;

import java.util.Stack;

public class MinStack {
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int min = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        dataStack.push(x);
        this.min = Math.min(x, this.min);
        minStack.push(this.min);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
        this.min = minStack.isEmpty() ? Integer.MAX_VALUE : this.minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
