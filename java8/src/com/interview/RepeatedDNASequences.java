package com.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> results = new ArrayList<>();

		Map<String, Integer> frequency = new HashMap<>();

		for (int i = 0; i < s.length() - 9; i++) {
			String ss = s.substring(i, i+10);

			if (frequency.containsKey(ss)) {
				// frequency.put(ss, frequence.get(ss) + 1);
			} else {
				frequency.put(ss, 1);
			}
		}
		for (Map.Entry<String, Integer> mapElement: frequency.entrySet()) {
		 	if (mapElement.getValue() > 1) {
				results.add(mapElement.getKey());
			}
		}

		return results;
	}
}
