import java.util.Stack;

/**
 * Created by steven.
 * Date: 30/9/18
 * Problem: https://leetcode.com/problems/remove-k-digits/description/
 * Tags: 
 * Algo: 
 * TimeComplexity: 
 * SpaceComplexity: 
 */
 
public class RemoveKDigits {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(removeKdigits("1432219", 3));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            while (k != 0 && stack.size() != 0 && stack.peek() > c) {
                stack.pop();
                k -= 1;
            }

            if (stack.size() != 0 || c != '0') {
                stack.push(c);
            }
        }

        while (k != 0) {
            stack.pop();
            k -= 1;
        }

        if (stack.size() == 0) {
            return "0";
        } else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(String.valueOf(stack.pop()));
            }
            return sb.reverse().toString();
        }
    }
}
