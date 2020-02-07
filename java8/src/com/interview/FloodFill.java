package com.interview;

import java.util.Arrays;
import java.util.Stack;

public class FloodFill {
	private final int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	private void dfsWithStack(int[][] image, int sr, int sc, int newColor, int mainColor) {
		image[sr][sc] = newColor;
		Stack<int[]> st = new Stack<>();

		st.add(new int[]{sr, sc});

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

	private void dfs(int[][] image, int sr, int sc, int newColor, int startColor)  {
		image[sr][sc] = newColor;

		for (int i = 0; i < 4; i++) {
			int u = sr + deltas[i][0];
			int v = sc + deltas[i][1];
			
			if (u < image.length && u >= 0 && v < image[0].length && v >= 0
				&& image[u][v] == startColor
				) {
				dfs(image, u, v, newColor, startColor);
			}
		}
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int startColor = image[sr][sc];

		if (newColor != startColor) {
			dfs(image, sr, sc, newColor, startColor);
		}

		return image;
	}
}
