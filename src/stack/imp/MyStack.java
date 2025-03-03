package stack.imp;

import java.util.EmptyStackException;

public class MyStack <T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public void push(T data) {
        StackNode<T> newNode = new StackNode<>(data);
        newNode.next = top;
        top = newNode;
    }
}
