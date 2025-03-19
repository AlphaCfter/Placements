package stack;

import com.sun.net.httpserver.HttpServer;

/**
 * The ParenthesisStacks class is used to check if parentheses in a given string are balanced.
 * It uses a stack to push and pop opening and closing parentheses and determines if they match properly.
 */
public class ParenthesisStacks {

    static char[] stack = new char[20];  // Stack to hold the characters
    static int TOS = 0;  // Top of Stack (TOS) index

    /**
     * Pops a value from the stack. If the stack is empty, it will notify the user.
     */
    private static void pop() {
        if (TOS == 0) {
            System.out.println("Stack is empty");
        } else {
            TOS--;
            // Uncomment the next line to print the popped value for debugging
            // char value = stack[TOS];
            // System.out.println("Popped value: " + value);
        }
    }

    /**
     * Pushes a value onto the stack. If the stack is full, it will notify the user.
     *
     * @param value The value to be pushed onto the stack
     */
    private static void push(char value) {
        if (TOS < stack.length) {
            stack[TOS] = value;
            TOS++;
        } else {
            System.out.println("Stack is full");
        }
    }

    /**
     * Displays the contents of the stack for debugging purposes.
     * If the stack is empty, it prints a message indicating so.
     */
    private static void display() {
        if (TOS == 0) {
            System.out.println("Stack is empty");
        } else {
            for (int i = 0; i < TOS; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    static boolean isEmpty() {
        return TOS == 0;
    }

    /**
     * Checks if the parentheses in a given string are balanced using a stack.
     * It pushes an opening parenthesis '(' onto the stack and pops it when it encounters a closing parenthesis ')'.
     * If there is any unmatched closing parenthesis or if there are leftover opening parentheses,
     * it will return false. Otherwise, it returns true.
     *
     * @param c The string containing the parentheses to check
     * @return true if the parentheses are balanced, false otherwise
     */
    static boolean checkForBrackets(String c) {
        // Convert the string into a char array
        char[] charArray = c.toCharArray();

        // Process each character in the array
        for (char ch : charArray) {
            if (ch == '(') {
                push('(');  // Push opening parenthesis onto the stack
            } else if (ch == ')') {
                if (isEmpty()) {
                    return false;  // If stack is empty, no matching '(' for ')'
                }
                pop();  // Pop the last '(' from the stack
            }
        }

        // Return true if the stack is empty, meaning all parentheses are balanced
        return isEmpty();
    }

    // Uncomment this block if you want to work with Character[] instead of char[]
    /*
    static boolean checkForBrackets(String c) {
        // Convert String to Character[] manually
        Character[] characterArray = new Character[c.length()];
        for (int i = 0; i < c.length(); i++) {
            characterArray[i] = c.charAt(i);
        }

        // Process each Character in the array
        for (Character ch : characterArray) {
            if (ch == '(') {
                push('(');
            } else if (ch == ')') {
                if (isEmpty()) {
                    return false; // There's no matching opening bracket
                }
                pop();
            }
        }

        return isEmpty();  // The stack should be empty if all brackets are balanced
    }
    */

    /**
     * The main method to test the checkForBrackets method with different expressions.
     *
     * @param args The command line arguments (not used in this case)
     */
    public static void main(String[] args) {
        // Test cases
        String exp1 = "()";   // Balanced expression
        String exp2 = "((()"; // Unbalanced expression

        // Check if parentheses in the expressions are balanced
        boolean b = checkForBrackets(exp1);
        boolean c = checkForBrackets(exp2);

        // Print the results
        System.out.println("Expression 1 balanced: " + b);  // true
        System.out.println("Expression 2 balanced: " + c);  // false
    }
}
