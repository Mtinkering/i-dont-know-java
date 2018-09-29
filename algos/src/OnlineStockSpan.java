import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by steven.
 * Date: 29/9/18
 * Problem: https://leetcode.com/problems/online-stock-span/description/
 * Tags: 
 * Algo: 
 * TimeComplexity: 
 * SpaceComplexity: 
 */


public class OnlineStockSpan {
    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(29));
        System.out.println(obj.next(91));
        System.out.println(obj.next(62));
        System.out.println(obj.next(76));
        System.out.println(obj.next(51));
    }

    protected static class StockSpanner{
        Stack<int[]> stack;
        Stack<int[]> maximaStack;

        public StockSpanner() {
            this.stack = new Stack<>();
            this.maximaStack = new Stack<>();
        }

        public int next(int price) {

            if (stack.size() != 0) {
                if (price >= stack.peek()[0]) {
                    stack.push(new int[] {price, stack.peek()[1] + 1});
                } else {
                    stack.push(new int[] {price, 1});

                    // Switch point
                    maximaStack.push(stack.peek());
                }
            } else {
                stack.push(new int[]{ price, 1});
                maximaStack.push(new int[]{ price, 1});
            }

            if (maximaStack.size() != 0 && stack.peek()[0] >= maximaStack.peek()[0]) {
                return stack.peek()[1] + maximaStack.peek()[1];
            } else {
                return stack.peek()[1];
            }
        }
    }
}
