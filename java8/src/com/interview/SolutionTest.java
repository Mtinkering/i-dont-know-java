package com.interview;

import java.util.HashMap;
import java.util.Map;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result0 {
	private static boolean checkIfPerfect(Map<Character,Integer> f) {
		List<Integer> values = new ArrayList<>(f.values());

		for(int i = 1; i < values.size(); i++) {
			if (values.get(i) != values.get(i-1)) {
				return false;
			}
		}
		return true;
	}


	public int findKthLargest(int[] nums, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> Integer.compare(a, b));

		for (int num: nums) {
			if (pq.size() < k) {
				pq.offer(num);
			} else if (num > pq.peek()) {
				pq.poll();
				pq.offer(num);
			}
		}

	 return 1;
	}

//	public static int perfectSubstring(String s, int k) {
//		int l = s.length();
//		int result = 0;
//		for (int i = 0; i < l; i++) {
//			Map<Character,Integer> frequency = new HashMap<>();
//
//			for (int j = i; j < l; j++) {
//				frequency.put(s.charAt(j), frequency.getOrDefault(s.charAt(j), 0) + 1);
//				int nKey = frequency.size();
//				if (nKey*k == (j - i + 1)) {
//					if (checkIfPerfect(frequency)) {
//						result++;
//					}
//				}
//			}
//		}
//
//		return result;
//	}
	public static int perfectSubstring(String s, int k) {
		List<List<Integer>> ranges = new ArrayList<>();
		return 1;
	}

}


class Result2 {

	/*
	 * Complete the 'countMeetings' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER_ARRAY firstDay
	 *  2. INTEGER_ARRAY lastDay
	 */

	public static int countMeetings(List<Integer> firstDay, List<Integer> lastDay) {
		List<List<Integer>> ranges = new ArrayList<>();
		int l = firstDay.size();
		int count = 0;

		for (int i = 0; i < l; i++) {
			List<Integer> range = new ArrayList<>();
			range.add(firstDay.get(i));
			range.add(lastDay.get(i));
			ranges.add(range);
		}

		ranges.sort((o1, o2) -> {
			int cmp = Integer.compare(o1.get(0), o2.get(0));
			if (cmp == 0) {
				cmp = Integer.compare(o1.get(1), o2.get(1));
			}
			return cmp;
		});

		int currentLeft = ranges.get(0).get(0) + 1;

		for(int i = 1; i < l; i++) {
			int left = ranges.get(i).get(0);
			int right = ranges.get(i).get(0);

			if (left >= currentLeft) {
				currentLeft = left + 1;
				count += 1;
			} else if (currentLeft <= right) {
				currentLeft = currentLeft + 1;
				count += 1;
			}
		}

		return count;
	}

}
//
//
//
//import java.io.*;
//	import java.math.*;
//	import java.security.*;
//	import java.text.*;
//	import java.util.*;
//	import java.util.concurrent.*;
//	import java.util.function.*;
//	import java.util.regex.*;
//	import java.util.stream.*;
//	import static java.util.stream.Collectors.joining;
//	import static java.util.stream.Collectors.toList;
//
//
//class Result {
//
//	/*
//	 * Complete the 'countMeetings' function below.
//	 *
//	 * The function is expected to return an INTEGER.
//	 * The function accepts following parameters:
//	 *  1. INTEGER_ARRAY firstDay
//	 *  2. INTEGER_ARRAY lastDay
//	 */
//
//	public static int countMeetings(List<Integer> firstDay, List<Integer> lastDay) {
//		List<List<Integer>> ranges = new ArrayList<>();
//		int l = firstDay.size();
//		int count = 1;
//
//		for (int i = 0; i < l; i++) {
//			List<Integer> range = new ArrayList<>();
//			range.add(firstDay.get(i));
//			range.add(lastDay.get(i));
//			ranges.add(range);
//		}
//
//		ranges.sort((o1, o2) -> {
//			int cmp = Integer.compare(o1.get(0), o2.get(0));
//			if (cmp == 0) {
//				cmp = Integer.compare(o1.get(1), o2.get(1));
//			}
//			return cmp;
//		});
//		int currentLeft = ranges.get(0).get(0) + 1;
//
//		for(int i = 1; i < l; i++) {
//			int left = ranges.get(i).get(0);
//			int right = ranges.get(i).get(1);
//
//			if (left >= currentLeft) {
//				currentLeft = left + 1;
//				count += 1;
//			} else if (currentLeft <= right) {
//				currentLeft = currentLeft + 1;
//				count += 1;
//			}
//		}
//
//		return count;
//	}
//
//}
//public class Solution {