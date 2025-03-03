package stack.imp;

import java.util.EmptyStackException;
import java.util.Stack;

public class SetOfStacks<T> extends Stack<T> {
    private final int capacity;
    private SetOfStacks<T> prevStack;
    private SetOfStacks<T> currentStack;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
        this.currentStack = this;
        this.prevStack = null;
    }

    public synchronized void pushV2(T node) {
        if (currentStack == null) {
            throw new EmptyStackException();
        }
        if (currentStack.size() == capacity) {
            SetOfStacks<T> nextStack = new SetOfStacks<>(capacity);
            nextStack.prevStack = currentStack;
            currentStack = nextStack;   //switching context
        }
        currentStack.push(node);
    }

    public synchronized T popV2() {
        if (currentStack == null || currentStack.isEmpty()) {
            throw new EmptyStackException();
        }
        T pop = currentStack.pop();
        if (currentStack.size() == 0) {
            currentStack = prevStack;   //switching context
        }
        return pop;
    }


}
