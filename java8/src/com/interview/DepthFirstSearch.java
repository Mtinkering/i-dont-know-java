package com.interview;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class DepthFirstSearch {
	private static List<ArrayList<Integer>> graph;
	private static int V;
	private static int E;

	private static List<Boolean> visited;

	public static void dfs(int src) {
		V = graph.size();
		visited = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			visited.add(false);
		}

		Stack<Integer> stack = new Stack<>();

		visited.set(src, true);
		stack.add(src);

		while (!stack.empty()) {
			int u = stack.peek();
			stack.pop();

			for (int i = 0; i < graph.get(u).size(); i++) {
				int v = graph.get(u).get(i);

				if (!visited.get(v)) {
					visited.set(v, true);
					stack.add(v);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		graph = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		int s = 0;
		dfs(s);
	}
}
