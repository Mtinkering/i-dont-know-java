import java.util.Stack;

/**
 * Created by steven.
 * Date: 29/9/18
 * Problem: https://leetcode.com/problems/simplify-path/discuss/25686/Java-10-lines-solution-with-stack
 * Tags:
 * Algo:
 * TimeComplexity: O(n)
 * SpaceComplexity:
 */

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println((simplifyPath("/home/").equals("/home")));
        System.out.println((simplifyPath("/a/./b/../../c/").equals("/c")));
        System.out.println((simplifyPath("/a/../../b/../c//.//").equals("/c")));
        System.out.println((simplifyPath("/a//b////c/d//././/..").equals("/a/b/c")));
        System.out.println((simplifyPath("/../").equals("/")));
        System.out.println((simplifyPath("/home//foo/").equals("/home/foo")));
        System.out.println((simplifyPath("/.").equals("/")));
        System.out.println((simplifyPath("/...").equals("/...")));
        System.out.println((simplifyPath("/home/of/foo/../../bar/../../is/./here/.").equals("/is/here")));
        System.out.println((simplifyPath("///eHx/..").equals("/")));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        for (String dir : path.split("/")) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!dir.equals("") && !dir.equals(".")) {
                stack.push(dir);
            }
        }

        return "/" + String.join("/", stack);
    }
}
