package stack.imp;

import java.util.Stack;

public class SortedStack {
    private Stack<Integer> stack;
    private Stack<Integer> reverseStack;

    public SortedStack() {
        stack = new Stack<>();
        reverseStack = new Stack<>();
    }

    public synchronized void push(Integer item) {
        if (!stack.isEmpty() && stack.peek() > item) {
            pushInOrder(item);
        }
        else {
            stack.push(item);
        }
    }

    private synchronized void pushInOrder(Integer item) {
        while (!stack.isEmpty() && stack.peek() > item) {
            reverseStack.push(stack.pop());
        }
        stack.push(item);
        while (!reverseStack.isEmpty()) {
            stack.push(reverseStack.pop());
        }
    }


}
