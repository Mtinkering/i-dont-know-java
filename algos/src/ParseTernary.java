import java.util.Stack;

/**
 * Created by steven.
 * Date: 29/9/18
 * Problem: https://leetcode.com/problems/ternary-expression-parser/description/
 * Tags: 
 * Algo: 
 * TimeComplexity: 
 * SpaceComplexity: 
 */
 

public class ParseTernary {
    public static void main(String[] args) {
        System.out.println(parseTernary("T?2:3").equals("2"));
        System.out.println(parseTernary("F?1:T?4:5").equals("4"));
        System.out.println(parseTernary("T?T?F:5:3").equals("F"));
    }

    public static String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop();
                char first = stack.pop();
                stack.pop();
                char second = stack.pop();

                if (c == 'T') {
                    stack.push(first);
                } else {
                    stack.push(second);
                }
            } else {
                stack.push(c);
            }
        }

        return String.valueOf(stack.peek());
    }
}
