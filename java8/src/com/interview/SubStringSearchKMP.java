package com.interview;

import java.util.Arrays;

public class SubStringSearchKMP {
	private int[] constructLPSTable(String pattern) {
		int len = pattern.length();

		int[] table = new int[len];
		Arrays.fill(table, 0);

		int i = 1;
		int j = 0;

		while (i < len && j < len) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				table[i] = j + 1;
				i++;
				j++;
			} else {
				if (j == 0) {
					i++;
				} else {
//					j = pattern.charAt(j - 1);
					// this minus one is because we are dealing with longest prefix suffix table.
					// so minus one means one less
					j = table[j - 1];
				}
			}
		}

		return table;
	}

	public boolean kmpSearch(String text, String pattern) {
		int[] lpsTable = constructLPSTable(pattern);
		System.out.println(Arrays.toString(lpsTable));
		int i = 0;
		int j = 0;

		while (i < text.length() && j < pattern.length()) {
			if (text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else {
				if (j == 0) {
					i++;
				} else {
					j = lpsTable[j - 1];
				}
			}
		}

		return j == pattern.length();
	}

	public static void main(String[] args) {
		String text = "abcxabcdabcdabcy";

		String pattern = "aabaabaaa";

		SubStringSearchKMP sskmp = new SubStringSearchKMP();
		System.out.println(sskmp.kmpSearch(text, pattern));
	}
}
