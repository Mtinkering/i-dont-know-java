package com.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SolutionTest {
	private final int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	private void dfsWithStack(int[][] image, int sr, int sc, int newColor, int mainColor) {
		image[sr][sc] = newColor;
		Stack<int[]> st = new Stack<>();

		int[] coor = {sr, sc};
		st.add(coor);

		while (!st.empty()) {
			int[] top = st.peek();
			st.pop();

			for (int i = 0; i < 4; i++) {
				int u = top[0] + deltas[i][0];
				int v = top[1] + deltas[i][1];

				if (u < image.length && u >= 0 && v < image[0].length && v >= 0
					&& image[u][v] == mainColor
					) {
					image[u][v] = newColor;
					st.add(new int[]{u, v});
				}
			}
		}
	}

	private void dfs(int[][] image, boolean[][] visited, int sr, int sc, int newColor)  {
		visited[sr][sc] = true;
		image[sr][sc] = newColor;

//		int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//		 int[][] deltas = {{1,2,3}};
//		 detal = new int[5];
//		 detal = ;
//		 detal = new int[]{1,2,3};

//		 int[] deltas = {1,2,3};

		for (int i = 0; i < 4; i++) {
			int[] delta = deltas[i];
			int dr = delta[0];
			int dc = delta[1];
			int u = sr + dr;
			int v = sc + dc;
			if (u < image.length && u >= 0 && v < image[0].length && v >= 0
				&& image[u][v] == image[sr][sc] && visited[u][v] == false
				) {
				dfs(image, visited, u, v, newColor);
			}
		}
//       if (sr + 1 < image.length && visited[sr+1][sc] == false) {

//       }

//       if (sr - 1 >= 0 && visited[sr-1][sc] == false) {
//         dfs(image, visited, sr - 1, sc, newColor);
//       }

//       if (sc + 1 < image[0].length && visited[sr][sc+1] == false) {
//         dfs(image, visited, sr, sc + 1, newColor);
//       }

//       if (sc - 1 >= 0 && visited[sr][sc-1] == false) {
//         dfs(image, visited, sr, sc - 1, newColor);
//       }
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int n = image.length;
		int m = image[0].length;

		boolean [][] visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], false);
		}

		dfs(image, visited,  sr, sc, newColor);

		return image;
	}

	public static void main(String[] args) {
//		Integer[] anArray = new Integer[]{1,2,3};
//		List<Integer> li = Arrays.asList(anArray);
//
//		li.add(2);

		String[] anArrayStr = new String[]{"hi", "there"};
		Stream<String> ss = Arrays.stream(anArrayStr);

		int[] intArray = new int[]{1,2};
		List<Integer> st = Arrays.stream(intArray).boxed().collect(Collectors.toList());
		st.add(1);

		
	}
}