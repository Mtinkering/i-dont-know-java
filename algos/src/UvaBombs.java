import java.util.*;

/**
 * Created by steven.
 * Date: 24/9/18
 * Problem: https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1594
 * Tags: 
 * Algo: BFS
 * TimeComplexity: O(V+E) or O(rxc) for BFS,
 * SpaceComplexity: 
 */
 
public class UvaBombs {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
         int r = scanner.nextInt();
         int c = scanner.nextInt();

         while (r != 0 && c != 0) {
             System.out.println(solve(r, c));

             r = scanner.nextInt();
             c = scanner.nextInt();
         }
    }

    private static int solve(int r, int c) {
        int[][] matrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = 0;
            }
        }

        int rows = scanner.nextInt();

        for (int i = 0; i < rows; i++) {
            int row = scanner.nextInt();
            int numberOfBombs = scanner.nextInt();

            for (int j = 0; j < numberOfBombs; j++) {
                int col = scanner.nextInt();
                matrix[row][col] = -1;
            }
        }

        int sx = scanner.nextInt();
        int sy = scanner.nextInt();
        int dx = scanner.nextInt();
        int dy = scanner.nextInt();

        bfs(sx, sy, dx, dy, matrix);

        return matrix[dx][dy] - 1;
    }

    private static void bfs(int sx, int sy, int dx, int dy, int[][] matrix) {
        List<Node> q = new ArrayList<>();

        q.add(new Node(sx, sy));
        matrix[sx][sy] = 1;

       List<Node> neighbors = new ArrayList<>();

        neighbors.add(new Node(0, 1));
        neighbors.add(new Node(0, -1));
        neighbors.add(new Node(1, 0));
        neighbors.add(new Node(-1, 0));

        while (q.size() != 0) {
            List<Node> nextLevel = new ArrayList<>();

            for (Node node : q) {
                if (node.x == dx && node.y == dy) {
                    break;
                }

                for (Node neighbor : neighbors) {
                    int x = neighbor.x + node.x;
                    int y = neighbor.y + node.y;

                    if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] == 0) {
                        nextLevel.add(new Node(x, y));
                        matrix[x][y] = matrix[node.x][node.y] + 1;
                    }
                }
            }

            q = nextLevel;
        }
    }

    protected static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
