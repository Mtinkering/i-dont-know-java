package com.interview;

import java.util.ArrayList;
import java.util.List;

public class CanJump {
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] nums = new int[]{2,3,1,1,4};

		System.out.println(sol.canJump(nums));
	}


	static class Solution {
		private void bfs(int src, List<List<Integer>> graph, boolean[] visited) {
			visited[src] = true;

			List<Integer> q = new ArrayList<>();
			List<Integer> level = new ArrayList<>();

			q.add(src);

			while (!q.isEmpty()) {
				for (int k = 0; k < q.size(); k++) {
					int u = q.get(k);

					List<Integer> edges = graph.get(u);
					for (int i = 0; i < edges.size(); i++) {
						int v = edges.get(i);
						if (!visited[v]) {
							visited[v] = true;
							level.add(v);
						}
					}
				}
				q = level;
				level = new ArrayList<>();
			}
		}


		private List<List<Integer>> buildGraph(int[] nums) {
			List<List<Integer>> graph = new ArrayList<>();

			for (int i = 0; i < nums.length; i++) {
				List<Integer> edges = new ArrayList<>();
				for (int j = 1; j <= nums[i]; j++) {
					edges.add(i + j);
				}
				graph.add(edges);
			}

			return graph;
		}

		public boolean canJump(int[] nums) {
			int n = nums.length;
			if (n == 0) {
				return false;
			}

			if (n == 1) {
				return true;
			}

			// Construct the graph
			List<List<Integer>> graph = buildGraph(nums);

			for (int i = 0; i < graph.size(); i++) {
				List<Integer> edges = graph.get(i);
				for (int j = 0; j < edges.size(); j++) {
					System.out.println(edges.get(j));

				}
				System.out.println("");
			}

			// Explore the graph
			boolean[] visited = new boolean[n];
			// How to better fill the array

			for (int i = 0; i < n; i++) {
				visited[i] = false;
			}

			// int source = nums[0];

			bfs(0, graph, visited);

			return visited[n-1];
		}
	}

}
