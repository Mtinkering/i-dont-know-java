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
        Stack<Integer> stack;
        List<Integer> prices;
        int cur;

        public StockSpanner() {
            stack = new Stack<>();
            prices = new ArrayList<>();
            cur = 0;
        }

        public int next(int price) {
            prices.add(price);
            cur += 1;

            while (!stack.isEmpty() && prices.get(stack.peek() - 1) <= price) {
                stack.pop();
            }

            int top;
            if (!stack.isEmpty()) {
                top = stack.peek();
            } else {
                top = 0;
            }

            stack.push(cur);


            return cur - top;
        }
    }
}
