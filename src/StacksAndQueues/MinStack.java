/*  Min Stack

    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
    Note that all the operations have to be constant time operations. Questions to ask the interviewer :
    Q: What should getMin() do on empty stack?
    A: In this case, return -1.

    Q: What should pop do on empty stack?
    A: In this case, nothing.

    Q: What should top() do on empty stack?
    A: In this case, return -1

 */
package StacksAndQueues;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        System.out.println(getMin());
        push(10);
        System.out.println(getMin());
        push(4);
        System.out.println(getMin());
        push(7);
        System.out.println(getMin());
        push(9);
        System.out.println(getMin());
        push(3);
        System.out.println(getMin());
        push(20);
        System.out.println(stack);
        System.out.println(getMin());
        System.out.println(top());
        pop();
        System.out.println(stack);
        pop();
        System.out.println(stack);
        System.out.println(getMin());
        System.out.println(top());
    }
    static Stack<Integer> stack;
    static Stack<Integer> minStack;
    MinStack(){
        stack  = new Stack<>();
         minStack = new Stack<>();
    }
    public static void push(int x) {
        if(stack.empty() || minStack.empty()){
            stack.removeAllElements();
            minStack.removeAllElements();
        }
        stack.push(x);
        if(minStack.empty()){
            minStack.push(x);
        }else if(x <= getMin()){
            minStack.push(x);
        }
    }

    public static void pop() {
        if(stack.empty()){
            minStack.removeAllElements();
            return;
        }
        int x = stack.peek();
        stack.pop();
        if(!minStack.empty()) {
            if (x == getMin()) {
                minStack.pop();
            }
        }
    }

    public static int top() {
        if(stack.empty()){
            minStack.removeAllElements();
            return -1;
        }
        return stack.peek();
    }

    public static int getMin() {
        if(minStack.empty() || stack.empty()) return -1;
        return minStack.peek();
    }
}
