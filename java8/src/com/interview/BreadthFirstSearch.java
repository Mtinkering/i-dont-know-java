package com.interview;

import java.util.*;

public class BreadthFirstSearch {
	private static List<ArrayList<Integer>> graph;
	private static int V;
	private static int E;

	private static List<Boolean> visited;

	public void bfs(int s, List<ArrayList<Integer>> graph, List<Boolean> visited) {
		 V = graph.size();

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < V; i++) {
			visited.add(false);
		}

		visited.set(s, true);
		q.offer(s);

		while (q.size() != 0) {
			int u = q.poll();

			for (int i = 0; i < graph.get(u).size(); i++) {
				int v = graph.get(u).get(i);

				if (visited.get(v) == false) {
					q.offer(u);
					visited.set(u, true);
				}
			}
		}
	}
}
