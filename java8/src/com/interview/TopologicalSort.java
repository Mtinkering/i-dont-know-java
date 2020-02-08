package com.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
	private List<ArrayList<Integer>> adjVertices = new ArrayList<>();


	private void toposortUtil(int src, List<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> result) {

		visited[src] = true;

		for(int u: adj.get(src)) {
			if (!visited[u]) {
				toposortUtil(u, adjVertices, visited, result);
			}
		}

		result.push(src);
	}


	public List<Integer> toposort(int src) {
		Stack<Integer> result = new Stack<>();

		boolean[] visited = new boolean[adjVertices.size()];

		toposortUtil(src, adjVertices, visited, result);

		return result;
	}
}
