/**
 * Created by steven.
 * Date: 2/8/18
 * Problem: https://leetcode.com/problems/rotate-array/
 * Tags: Array
 */
 
public class RotateArray {
    public static void main(String[] args) {
        int[] myArray = {1,2,3,4,5,6};

        rotate(myArray, 4);
        System.out.println(java.util.Arrays.toString(myArray));
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;

        if (k == 0 || k == nums.length) {
            return;
        }

        int nextIndex;
        int currentSeed = 0;
        int startIndex = currentSeed;
        int prevNum = nums[startIndex];

        for (int i = 0; i < nums.length; i++) {
            nextIndex = (startIndex + k)% nums.length;

            // Swap the numbers
            int temp = nums[nextIndex];
            nums[nextIndex] = prevNum;
            prevNum = temp;
            startIndex = nextIndex;

            // When the same,
            // increase the seed
            if (startIndex == currentSeed) {
                currentSeed += 1;
                startIndex = currentSeed;
                prevNum = nums[startIndex];
            }
        }

    }
}
