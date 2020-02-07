package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DFSRecur {
	private static List<ArrayList<Integer>> graph;
	private static int V;
	private static int E;

	private static List<Boolean> visited;

	private static void dfs(int s) {
		visited.set(s, true);

		for (int i = 0; i < graph.get(s).size(); i++) {
			int v = graph.get(s).get(i);

			if (!visited.get(v)) {
				dfs(v);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		graph = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}


		visited = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			visited.add(false);
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
