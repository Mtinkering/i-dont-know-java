package com.interview;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;
class TrieNode {
	public Map<Character, TrieNode> children;
	public List<String> suggestions;

	public TrieNode() {
		children = new HashMap<>();
		suggestions = new ArrayList<>();
	}
}

class Trie {
	TrieNode head;

	public Trie() {
		head = new TrieNode();
	}

	public void insert(String w) {
		TrieNode cur = head;

		for (char c: w.toCharArray()) {
			if (!cur.children.containsKey(c)) {
				cur.children.put(c, new TrieNode());
			}
			if (cur.suggestions.size() < 3) cur.suggestions.add(w);
			cur = cur.children.get(c);
		}
	}

	public List<String> search(String q) {
		TrieNode cur = head;

		for (char c: q.toCharArray()) {
			if (!cur.children.containsKey(c)) {
				return new ArrayList<String>();
			}
			cur = cur.children.get(c);
		}

		return cur.suggestions;
	}

}


class Solution {
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		Arrays.sort(products);
		Trie trie = new Trie();
		for (String product: products) {
			trie.insert(product);
		}

		List<List <String>> ans = new ArrayList<>();
		String q = "";
		for (int i = 0; i < searchWord.length(); i++) {
			q += searchWord.charAt(i);
			List<String> suggestions = trie.search(q);
			if (suggestions.size() == 0)
				ans.add(new ArrayList<String>());
		}

		return ans;
	}
}