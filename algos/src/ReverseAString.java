/**
 * Created by steven.
 * Date: 14/8/18
 * Problem: Write a function to reverse a string.
 * Tags: 2 pointers
 */

public class ReverseAString {
    public static void main(String[] args) {
        String e = "example";
        System.out.println(reverse(e));
    }

    private static String reverse(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }
}
