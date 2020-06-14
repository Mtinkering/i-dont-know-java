//package com.interview;
//
//import java.util.ArrayList;
//import java.util.List;
//
///* Problem Name is &&& HashMap &&& PLEASE DO NOT REMOVE THIS LINE. */
//
///**
// * Instructions to candidate.
// * 1) Run this code in the REPL to observe its behaviour. The
// * execution entry point is main().
// * 2) Consider adding some additional tests in doTestsPass().
// * 3) Implement MyHashMap correctly.
// * 4) If time permits, some possible follow-ups.
// */
//
//public class GoldmanSachs
//{
//
//
//	/**
//	 * class MyHashMap
//	 *
//	 * Associates a key-value pair in memory such that lookups
//	 * and inserts can be performed in O(1) time for a reasonably
//	 * small set of data, and scales linearly (at worst) for larger
//	 * sets of key-value pairs.
//	 *
//	 * Each unique key is associated with one single value.
//	 */
//	private class MyHashMap<K, V>
//	{
//		class Node {
//			public K key;
//			public V value;
//		}
//
//		private final int HASH_SIZE = 100;
//		private List<List<Node>> arr;
//
//		MyHashMap() {
//
//			arr = new ArrayList<>();
//
//			for (int i = 0; i < HASH_SIZE; i++) {
//				List<Node> bucket = new ArrayList<>();
//				arr.add(bucket);
//			}
//		}
//
//
//		// Index of the key, value pair inside the array
//		private int hashFunction(K key) {
//			return key.hashCode%HASH_SIZE;
//		}
//
//
//		void put(K key, V value)
//		// void put(int key, int value)
//		{
//			int index = hashFunction(key);
//			boolean existing = false;
//
//			for (Node node: arr.get(index)) {
//
//				// Update the value if the keys are the same
//				if (node.key == key) {
//					node.value = value;
//					existing = true;
//					break;
//				}
//			}
//
//			if (!existing) {
//				Node node = new Node(key, value);
//				arr.get(index).append(node);
//			}
//		}
//
//		V get(K key)
//		// int get(int key)
//		{
//			int index = hashFunction(key);
//
//			for (Node node: arr.get(index)) {
//				if (node.key == key) {
//					return node.value;
//				}
//			}
//
//			return null;
//		}
//	}
//
//	/**
//	 * bool doTestsPass()
//	 * Runs various tests. Returns true if tests pass. Otherwise,
//	 * returns false.
//	 */
//	public void doTestsPass()
//	{
//		// todo: implement more tests, please
//		// feel free to make testing more elegant
//		int[][] testCases = {{1, 2}, {3, 4}, {5, 6}};
//		boolean passed = true;
//
//		MyHashMap<Integer, Integer> map = new MyHashMap<Integer, Integer>();
//
//		for (int[] test : testCases)
//		{
//			Integer key = test[0];
//			Integer value = test[1];
//
//			map.put(key, value);
//
//			if (!value.equals(map.get(key)))
//			{
//				System.out.println("Test failed [" + key + "," + value + "]");
//				passed = false;
//			}
//		}
//
//		if (passed)
//		{
//			System.out.println("All tested passed");
//		}
//
//	}
//
//	/**
//	 * Execution entry point.
//	 */
//	public static void main(String args[])
//	{
//		new Solution().doTestsPass();
//	}
//}
