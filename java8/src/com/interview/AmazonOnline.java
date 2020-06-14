package com.interview;

import java.util.*;

public class AmazonOnline {
	public static void main(String[] args) {

	}
//	package com.interview;
//
//import java.util.*;
//	class Test {
//
//		public static void main(String[] args) {
//			Solution sol = new Solution();
//
//			List<String> strs = new ArrayList<>();
//			strs.add("is");
//			strs.add("are");
//			strs.add("a");
//			sol.retrieveMostFrequentlyUsedWords("Rose is a flower red rose are flower", strs);
//		}
//
//		static class Solution
//		{
//			// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
//			List<String> retrieveMostFrequentlyUsedWords(String helpText,
//																									 List<String> wordsToExclude)
//			{
//				// Convert to set for faster lookup
//				Set<String> toExclude = new HashSet<>();
//				for (String word: wordsToExclude) {
//					toExclude.add(word);
//				}
//
//				List<String> ans = new ArrayList<>();
//
//				// Count the frequency
//				Map<String, Integer> freq = new HashMap<>();
//
//				int s = helpText.length();
//				int j = 0;
//				int currentMaxFreq = -1;  // Keep the max
//
//				for (int i = 0; i < s; i++) {
//					char c = Character.toLowerCase(helpText.charAt(i));
//
//
//					if (c < 'a' || c > 'z' || i == s - 1) {
//						String word = "";
//						if (i == s - 1) {
//							if (j < i) word = helpText.substring(j, s).toLowerCase();
//						} else {
//							word = helpText.substring(j, i).toLowerCase();
//							j = i + 1;
//						}
//
//						if (word.length() != 0 && !toExclude.contains(word)) {
//							// we want this word
//							freq.put(word, freq.getOrDefault(word, 0) + 1);
//							currentMaxFreq = Math.max(currentMaxFreq, freq.get(word));
//						}
//					}
//				}
//
//				for (Map.Entry<String, Integer> pair: freq.entrySet()) {
//					if (pair.getValue() == currentMaxFreq) ans.add(pair.getKey());
//				}
//
//				return ans;
//			}
//			// METHOD SIGNATURE ENDS
//		}
//	}




// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
	private int getStartIndex(String l) {
		int i = 0;

		while (i < l.length()) {
			if (l.charAt(i) == ' ') return i + 1;
		}

		throw new Error("Should have space");
	}

	private boolean checkIfAllIntegers(String l) {
		for (int i = 0; i < l.length(); i++) {
			if (!Character.isDigit(l.charAt(i))) return false;
		}
		return true;
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public List<String> reorderLines(int logFileSize, List<String> logLines)
	{

		logLines.sort((l1, l2) -> {
			int i1 = getStartIndex(l1);
			int i2 = getStartIndex(l2);

			String s1 = l1.substring(i1, l1.length()).toLowerCase();
			String s2 = l2.substring(i2, l2.length()).toLowerCase();

			boolean t1 = checkIfAllIntegers(s1);
			boolean t2 = checkIfAllIntegers(s2);

			if (t1 == true && t2 == true) return 0;

			// If l1 is digits and l2 is not, l2 is higher
			if (t1) return -1;

			// If l2 is digits and l1 is not, l1 is higher
			if (t2) return 1;

			// Now both are alphanumberic
			// 2 strings equal then compare the identifier
			if (s1.equals(s2)) {
				return l1.substring(0, i1).toLowerCase().compareTo(l2.substring(0, i2).toLowerCase());
			}

			// If not equal
			return s1.compareTo(s2);
		});

		return logLines;
	}
	// METHOD SIGNATURE ENDS
}
}
