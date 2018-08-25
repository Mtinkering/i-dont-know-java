/**
 * Created by steven.
 * Date: 13/8/18
 * Problem: http://www.lightoj.com/volume_showproblem.php?problem=1174
 * Tags: dijkstra
 * Algo: min distance is the max total time of min from s to i, plus min from i to d, for all i in between s and d.
 * Complexity: ElogV, with V is number of vertices, E is the number of edges
 * Because with adjacency list, updating burn times take O(logV) each, total O(E) edges.
 * Remember we only go through edges once.
 * O((E+V)logV)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    public Integer id;
    public Integer dist;

    public Node(Integer id, Integer dist) {
        this.id = id;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node other) {
        return this.dist.compareTo(other.dist);
    }
}

public class Commandos {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for (int test = 0; test < t; test++) {
            int result = solve();
            int testCase = test + 1;
            System.out.println("Case " + testCase + ": " + result);
        }
        scanner.close();
    }

    public static void dijkstra(int s, List<List<Node>> graph, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[s] = 0;
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node top = pq.poll();
            int u = top.id;
            int w = top.dist;

            for (int i = 0; i < graph.get(u).size(); i++) {
                Node neighbor = graph.get(u).get(i);
                if (w + neighbor.dist < dist[neighbor.id]) {
                    dist[neighbor.id] = w + neighbor.dist;
                    pq.add(new Node(neighbor.id, dist[neighbor.id]));
                }
            }
        }
    }

    public static int solve() {
        int n = scanner.nextInt();
        int r = scanner.nextInt();

        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < r; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            graph.get(u).add(new Node(v, 1));
            graph.get(v).add(new Node(u, 1));
        }

        int s = scanner.nextInt();
        int d = scanner.nextInt();

        int[] distFromS = new int[n];
        int[] distFromD = new int[n];

        for (int i = 0; i < n; i++) {
            distFromS[i] = Integer.MAX_VALUE;
            distFromD[i] = Integer.MAX_VALUE;
        }

        dijkstra(s, graph, distFromS);
        dijkstra(d, graph, distFromD);

        int total = 0;
        for (int i = 0; i < n; i++) {
            int distance = distFromS[i] + distFromD[i];
            total = Math.max(total, distance);
        }

        return total;
    }
}
