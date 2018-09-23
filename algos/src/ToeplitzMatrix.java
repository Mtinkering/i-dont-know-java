public class ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2},
        };
        System.out.println(isToeplitzMatrix(matrix));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        if (n < 2 || m < 2) {
            return true;
        }

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (matrix[j][i] != matrix[j+1][i+1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
