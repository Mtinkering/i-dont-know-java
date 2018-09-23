import java.util.LinkedList;
import java.util.Queue;

public class ReshapeMatrix {
    public static void main(String[] args) {

    }
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length;
        int m = nums[0].length;

        if (n*m != r*c) return nums;

        Queue< Integer > queue = new LinkedList< >();

        int[][] newArr = new int[r][c];
        int l = 0;
        int k = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newArr[i][j] = nums[k][l];

                if (l == m - 1) {
                    l = 0;
                    k += 1;
                } else {
                    l += 1;
                }
            }
        }
        return newArr;
    }
}
