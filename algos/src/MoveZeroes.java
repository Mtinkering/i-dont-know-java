import java.util.Arrays;

/**
 * Created by steven.
 * Date: 2/8/18
 * Problem: https://leetcode.com/problems/move-zeroes/
 * Tags: Easy, Array
 */
 
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {1,0,1,3,12};

        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int p1 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[p1];
                nums[p1] = nums[i];
                nums[i] = temp;
                p1 += 1;
            }
        }
    }
}
