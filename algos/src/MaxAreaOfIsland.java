/**
 * Created by steven.
 * Date: 2/8/18
 * Problem: https://leetcode.com/problems/max-area-of-island/description/
 * Tags: BFS, DFS
 */
 
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int[][] getNeighbors(int x, int y) {
        int[][] results = {{x+1, y}, {x-1, y}, {x, y+1}, {x, y-1}};
        return results;
    }

    public  static boolean isValid(int[] neighbor, int[][] grid) {
        int x = neighbor[0];
        int y = neighbor[1];

        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1;
    }

    public static int areaOfIsland(int[][] grid, int x, int y) {
        grid[x][y] = 0;
        int area = 1;

        int[][] neighbors = getNeighbors(x, y);
        for (int[] neighbor: neighbors
             ) {
            if (isValid(neighbor, grid)) {
                area += areaOfIsland(grid, neighbor[0], neighbor[1]);
            }
        }

        return area;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, areaOfIsland(grid, i, j));
                }
            }
        }
        return maxArea;
    }
}
