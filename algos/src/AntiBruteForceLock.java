import java.util.*;

public class AntiBruteForceLock {
    protected static class DisjointSet {
        private int size;
        private int[] parent;
        private int[] ranks;

        public DisjointSet(int size) {
            this.size = size;
            this.parent = new int[size];
            this.ranks = new int[size];
        }

        public void makeSet() {
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                ranks[i] = 0;
            }
        }

        public void union(int data1, int data2) {
            int parent1 = findSet(data1);
            int parent2 = findSet(data2);

            if (parent1 == parent2) {
                return;
            }

            if (ranks[parent1] == ranks[parent2]) {
                ranks[parent2] += 1;
                parent[parent1] = parent2;
            } else if (ranks[parent1] < ranks[parent2]) {
                parent[parent1] = parent2;
            } else {
                parent[parent2] = parent1;
            }
        }

        public int findSet(int u) {
            if (parent[u] != u) {
                parent[u] = findSet(parent[u]);
            }
            return parent[u];
        }
    }

    protected static class Triad {
        int source;
        int target;
        int weight;
        Triad(int source, int target, int weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }
    }

    private static int kruskal(List<Triad> edges, int n) {
        Collections.sort(edges, (o1, o2) -> (o1.weight - o2.weight));

        DisjointSet ds = new DisjointSet(n);
        ds.makeSet();

        int i = 0;
        int cnt = 0;
        int total = 0;
        while (cnt != n - 1) {
            Triad edge = edges.get(i);
            i++;
            int u = ds.findSet(edge.source);
            int v = ds.findSet(edge.target);
            if (u != v) {
                ds.union(u, v);
                cnt += 1;
                total += edge.weight;
            }

        }
        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main (String[] args) {
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    private static int step(int x, int y) {
        int d = Math.abs(x - y);
        if (d > 5) {
            d = 10 - d;
        }
        return d;
    }

    private static int distance(int a, int b) {
       return step(a/1000, b/1000) + step((a%1000)/100, (b%1000)/100) + step((a%100)/10, (b%100)/10) + step(a%10, b%10);
    }

    private static void solve() {
        int n = scanner.nextInt();

        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        List<Triad> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int d = distance(data[i], data[j]);
                edges.add(new Triad(i, j, d));
            }
        }

        int mst = kruskal(edges, n);

        int m = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int d = distance(data[i], 0);
            m = Math.min(m, d);
        }
        System.out.println(mst+m);
    }
}
