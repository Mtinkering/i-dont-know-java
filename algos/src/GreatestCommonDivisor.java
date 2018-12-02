//layman: https://www.youtube.com/watch?v=JUzYl1TYMcU
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(greatestCommonDivisor(10, 5));
        System.out.println(greatestCommonDivisor(5, 10));
    }

    private static int greatestCommonDivisor(int x, int y) {
        return x%y == 0 ? x/y: greatestCommonDivisor(y, x%y);
    }
}
