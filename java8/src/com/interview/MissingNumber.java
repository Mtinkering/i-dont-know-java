package com.interview;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
	public static void main(String[] args) {
//		int[] nums = {9,6,4,2,3,5,7,0,1};
//
//		int result = nums[0];
//
//		for (int i = 1; i < nums.length; i++) {
//			result = result ^ nums[i];
//		}
//		System.out.println(result);

//
//		isPowerOf10(1L);
//		isPowerOf10(10L);
//		isPowerOf10(1000L);
//		isPowerOf10(4L);
//		isPowerOf10(0L);
		System.out.println(isPowerOf10(1000000000000000000L));
		System.out.println(isPowerOf10(1000000000000000001L));

	}

	private static boolean isPowerOf10(Long val) {
//		int power = (int) Math.log10(val);
//
//		return val == Math.pow(10, power);

		while (val > 9 && val % 10 == 0)
			val /= 10;
		return val == 1;
	}
}
