import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[] {89,62,70,58,47,47,46,76,100,70})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            int cur = temperatures[i];

            while (!stack.isEmpty() && cur >= temperatures[stack.peek()]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            } else {
                result[i] = 0;
            }
//            stack.push(new int[] {cur, i});
            stack.push(i);
        }

        return result;
    }
}
