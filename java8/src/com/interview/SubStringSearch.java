package com.interview;

import java.security.Key;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubStringSearch {
	private int[] computeLPS(char[] pattern) {
		int[] lps = new int[pattern.length];

		int j = 0;

		for (int i = 1; i < pattern.length; ) {
			if (pattern[i] == pattern[j]) {
				lps[i] = j + 1;
				i++;
				j++;
			} else {
				if (j == 0) {
					lps[i] = 0;
					i++;
				} else {
					j = lps[j-1];
					// j = lps[j] - 1; ?? This should be correct too because
					// we are talking about the length
				}
			}
		}

//		Map.Entry<Key, Value> x = new HashMap<>().entrySet()

		return lps;
	}

	public boolean KMP(char[] text, char[] pattern) {
		int[] lps = computeLPS(pattern);
		 System.out.println(Arrays.toString(lps));
		int i = 0;
		int j = 0;

		while (i < text.length && j < pattern.length) {
			if (text[i] == pattern[j]) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = lps[j-1];
				} else {
					i++;
				}
			}
		}

		if (j == pattern.length) {
			return true;
		}

		return false;
	}

		public static void main(String[] args) {
		String str = "abcabcdefx";
		String substring = "aabaabaaa";

		SubStringSearch ss = new SubStringSearch();
		boolean result = ss.KMP(str.toCharArray(), substring.toCharArray());
		System.out.println(result);
	}
}
