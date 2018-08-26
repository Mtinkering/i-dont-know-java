import java.util.Arrays;

public class FlippingAnImage {
    public static void main(String[] args) {
        int[][] x = flipAndInvertImage(new int[][]{
                {1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}
        });
        for (int[] y :
                x) {
            System.out.println(Arrays.toString(y));
        }
    }

    public static void flipAndInvert(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int temp = (arr[right] + 1)%2;
            arr[right] = (arr[left] + 1)%2;
            arr[left] = temp;
            left++;
            right--;
        }
    }

    public static int[][] flipAndInvertImage(int[][] arr) {
        for (int[] row :
                arr) {
            flipAndInvert(row);
        }

        return arr;
    }
}
