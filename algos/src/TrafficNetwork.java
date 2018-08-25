import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by steven.
 * Date: 25/8/18
 * Problem: https://www.spoj.com/problems/TRAFFICN/
 * Tags: dijkstra
 * Algo:  The shortest path after building the chosen one two-way road is the minimum among the 3
 *          s -> u -> v -> t # road 1
 *          s -> v -> u -> t # road 2
 *          s -> x.... -> t # without u-v
 * TimeComplexity: ElogV
 * SpaceComplexity:
 */
class Node1 implements Comparable<Node1> {
    public int id;
    public Integer dist;

    public Node1(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node1 o) {
        return this.dist.compareTo(o.dist);
    }
}

public class TrafficNetwork {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int result = solve();
            System.out.println(result);
        }

        scanner.close();
    }

    private static int solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int s = scanner.nextInt() - 1;
        int t = scanner.nextInt() - 1;

        List<List<Node1>> graphFromS = new ArrayList<>();
        List<List<Node1>> graphFromT = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graphFromS.add(new ArrayList<Node1>());
            graphFromT.add(new ArrayList<Node1>());
        }

        for (int i = 0; i < m; i++) {
            int d = scanner.nextInt() - 1;
            int c = scanner.nextInt() - 1;
            int l = scanner.nextInt();

            graphFromS.get(d).add(new Node1(c, l));
            graphFromT.get(c).add(new Node1(d, l));
        }

        List<int[]> proposals = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            int q = scanner.nextInt();
            proposals.add(new int[]{u,v,q});
        }

        int[] distFromS = new int[n];
        int[] distFromT = new int[n];

        for (int i = 0; i < n; i++) {
            distFromS[i] = Integer.MAX_VALUE;
            distFromT[i] = Integer.MAX_VALUE;
        }

        shortestPath(s, graphFromS, distFromS);
        shortestPath(t, graphFromT, distFromT);

        int answer = distFromS[t];

        for (int[] p: proposals) {
            int distance1 = distFromS[p[0]] + p[2] + distFromT[p[1]];
            int distance2 = distFromS[p[1]] + p[2] + distFromT[p[0]];

            answer = Math.min(answer, distance2);
            answer = Math.min(answer, distance1);
        }

        return answer;
    }

    private static void shortestPath(int src, List<List<Node1>> graph, int[] dist) {
        PriorityQueue<Node1> pq = new PriorityQueue<>();
        pq.add(new Node1(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            Node1 top = pq.poll();
            int u = top.id;
            int w = top.dist;

            if (w != dist[u]) {
                continue;
            }

            for (Node1 neighbor: graph.get(u)) {
                if (w + neighbor.dist < dist[neighbor.id]) {
                    pq.add(new Node1(neighbor.id, w+ neighbor.dist));
                    dist[neighbor.id] = w+ neighbor.dist;
                }
            }
        }
    }
}
