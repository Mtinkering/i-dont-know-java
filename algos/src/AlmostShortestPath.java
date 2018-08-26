import java.util.*;

class Location implements Comparable<Location> {
    public Integer id;
    public Integer dist;

    public Location(Integer id, Integer dist) {
        this.id = id;
        this.dist = dist;
    }

    @Override
    public int compareTo(Location other) {
        return this.dist.compareTo(other.dist);
    }
}

public class AlmostShortestPath {
    private static final Scanner scanner = new Scanner(System.in);

    private static void solve(int n, int m) {
        int source = scanner.nextInt();
        int destination = scanner.nextInt();

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int p = scanner.nextInt();

            graph.get(u).add(new int[]{v, p});
        }

        int[] dist = new int[n];
        int[] thePath = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            thePath[i] = -1;
        }

        dijkstra(source, destination, graph, dist, thePath);

//        System.out.println(Arrays.toString(thePath));

        int shortestPath = dist[destination];
        int almostShortestPath = Integer.MIN_VALUE;

        while (almostShortestPath <= shortestPath) {
            int child = destination;
            int parent = thePath[child];

            while (parent != -1) {
                List<int[]> temp = new ArrayList<>();

                for (int[] t: graph.get(parent)
                     ) {
                    if (t[0] != child) {
                        temp.add(t);
                    }
                }
                graph.set(parent, temp);

                child = parent;
                parent = thePath[child];
            }

            dist = new int[n];
            thePath = new int[n];
            for (int i = 0; i < n; i++) {
                dist[i] = Integer.MAX_VALUE;
                thePath[i] = -1;
            }
            dijkstra(source, destination, graph, dist, thePath);
            almostShortestPath = dist[destination];
        }

        if (almostShortestPath != Integer.MAX_VALUE) {
            System.out.println(almostShortestPath);
        } else {
            System.out.println(-1);
        }
    }

    private static void dijkstra(int s, int d, List<List<int[]>> graph, int[] dist, int[] thePath) {
//        PriorityQueue<Location> pq = new PriorityQueue<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{s, 0});
        dist[s] = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int u = top[0];
            int w = top[1];

            if (u == d) {
                break;
            }

            if (w != dist[u]) {
                continue;
            }

            for (int i = 0; i < graph.get(u).size(); i++) {
                int[] neighbor = graph.get(u).get(i);
                if (w + neighbor[1] < dist[neighbor[0]]) {
                    dist[neighbor[0]] = w + neighbor[1];
                    pq.add(new int[]{neighbor[0], dist[neighbor[0]]});
                    thePath[neighbor[0]] = u;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        while (n != 0 && m != 0) {
            solve(n, m);

            n = scanner.nextInt();
            m = scanner.nextInt();
        }
        scanner.close();
    }
}
