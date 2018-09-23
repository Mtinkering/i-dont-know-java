import java.util.Arrays;

public class TranposeMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6}
        };

        for (int[] row :
                transpose(arr)) {
            System.out.println(Arrays.toString(row));

        }
    }

    public static int[][] transpose(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int[][] newArray = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newArray[i][j] = arr[j][i];
            }
        }
        return  newArray;
    }
}
