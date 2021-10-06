package Stack;

import java.util.EmptyStackException;

/**
 * Driver for the Stacks.
 */
public class StackDriver {
    public static void main(String [] args) {

        System.out.println("Creating a vector stack of integers of dynamic size 15.");
        Stack<Integer> stack = new VectorStack<>(15);
        System.out.println("Check empty (should be true): " + stack.empty());
        System.out.println("Pushing 15 values onto the stack");
        for (int i = 0; i < 15; i++) {
            System.out.print(" " + stack.push(i));
        }
        System.out.println();
        System.out.println("Attempt to push another value (should resize).");
        try {
            stack.push(16);
        } catch (StackOverflowError e) {
            System.out.println("FAIL");
        }
        System.out.println("Attempt peek (should be 16): " + stack.peek());
        System.out.println("Attempt pop (should be 16): " + stack.pop());
        System.out.println("Check empty (should be false): " + stack.empty());
        System.out.println("Attempt peek (should be 14): " + stack.peek());
        System.out.println("Attempt pop (should be 14): " + stack.pop());
        System.out.println("Attempting to pop all values from the stack...");
        while (!stack.empty())
            System.out.print(" " + stack.pop());
        System.out.println();
        System.out.println("Attempting one more pop (should fail).");
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Successful fail.");
        }
        System.out.println("Attempting one more peek (should fail).");
        try {
            stack.peek();
        } catch (EmptyStackException e) {
            System.out.println("Successful fail.");
        }
        System.out.println("Attempting null push: " + stack.push(null));
        System.out.println("Checking if empty (should be false): " + stack.empty());
        System.out.println("Checking if peek returns null (should be null): " + stack.peek());
        System.out.println("Checking if pop returns null (should be null): " + stack.pop());
        System.out.println("Checking if empty (should be true): " + stack.empty());
    }
}
