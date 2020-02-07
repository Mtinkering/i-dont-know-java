import java.util.*;

/**
 * Created by steven.
 * Date: 2/12/18
 * Problem: http://acm.timus.ru/problem.aspx?space=1&num=1196
 * Tags: 
 * Algo: 
 * TimeComplexity: 
 * SpaceComplexity: 
 */
 
public class HistoryExam {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        Set<Integer> pSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            pSet.add(scanner.nextInt());
        }

        int m = scanner.nextInt();
        List<Integer> sList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            sList.add(scanner.nextInt());
        }

        solve(pSet, sList);
    }

    private static void solve(Set<Integer> pSet, List<Integer> sList) {
        int counter = 0;

        for (int x : sList) {
            if (pSet.contains(x)) {
               counter += 1;
            }
        }

        System.out.println(counter);
    }
}
