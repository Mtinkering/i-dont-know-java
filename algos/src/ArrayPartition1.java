/**
 * Created by steven.
 * Date: 26/8/18
 * Problem: https://leetcode.com/problems/array-partition-i/
 * Tags: Array
 * Algo: just sort, to miminize the thing we throw away
 * TimeComplexity: 
 * SpaceComplexity: 
 */
 
import java.util.Arrays;

public class ArrayPartition1 {
    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        System.out.println(arrayPairSum(nums));
    }

//    public static int arrayPairSum(int[] nums) {
//        Arrays.sort(nums);
//
//        int total = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (i%2 == 0) {
//                total += nums[i];
//            }
//        }
//        return total;
//    }

    public static int arrayPairSum(int[] nums) {
        int[] arr = new int[20001];

        int lim = 10000;

        for (int num: nums) {
            arr[num + lim]++;
        }

        int total = 0;
        boolean flag = true;

        for (int i = 0; i < 20001;) {
            if (arr[i] != 0 && flag == true) {
                total += (i - lim);
                arr[i]--;
                flag = false;
            } else if (arr[i] != 0 && flag == false) {
                arr[i]--;
                flag = true;
            } else {
                i++;
            }
        }
        return total;
    }
}

