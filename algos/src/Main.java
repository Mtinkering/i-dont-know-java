public class Main {
    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("(()(()))"));
    }

    public static int scoreOfParentheses(String S) {
        int res = 0, layers = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') layers++; else layers--;
            if (S.charAt(i) == '(' && S.charAt(i + 1) == ')') res += 1 << (layers - 1);
        }
        return res;
    }
}
