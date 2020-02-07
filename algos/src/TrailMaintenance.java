import java.util.*;

public class TrailMaintenance {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main (String[] args) {
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            solve(i);
        }
    }

    private static void solve(int test) {
        System.out.println("Case " + (test+1) + ":");
        int n = scanner.nextInt();
        int w = scanner.nextInt();

        DisjointSet ds = new DisjointSet(n);
        ds.makeSet();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int numberOfUnion = 0;
        int total = 0;
        for (int j = 0; j < w; j++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            int l = scanner.nextInt();
            int up = ds.findSet(u);
            int vp = ds.findSet(v);
            if (up != vp) {
                ds.union(u, v);
                numberOfUnion += 1;
                total += l;
                pq.add(-l);
            } else {
                pq.add(-l);
                int last = - pq.poll();
                total = total + l - last;
            }
            if (numberOfUnion < n - 1) {
                System.out.println(-1);
            } else {
                System.out.println(total);
            }
        }
    }

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
}
