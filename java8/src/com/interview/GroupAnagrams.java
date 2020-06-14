//package com.interview;
//
//import java.util.*;
//
//public class GroupAnagrams {
//	public static void main(String[] args) {
//		char[] x = new char[] {'1','2'};
//		System.out.println(x.toString());
////		Solution sol = new Solution();
////
////		String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
////
////		System.out.println(sol.groupAnagrams(strs));
//	}
//	public boolean canConstruct(String ransomNote, String magazine) {
//
//		int[] chars = new int[26];
//
//		for (char c: magazine.toCharArray()) {
//			int offset = c - 'a';
//			chars[offset]++;
//		}
//
//		for (char c: ransomNote.toCharacterArray()) {
//			int offset = c - 'a';
//			if (chars[offset] == 0) return false;
//			chars[offset]--;
//		}
//		return true;
//	}
//
////	static class Solution {
////		public List<List<String>> groupAnagrams(String[] strs) {
////			Map<String, List<String>> groups = new HashMap<>();
////
////			for (String str: strs) {
////				char[] chars = str.toCharArray();
////				Arrays.sort(chars);
////				String key = String.valueOf(chars);
////				if (groups.containsKey(key)) groups.put(key, new ArrayList<>());
////				groups.get(key).add(str);
////			}
////
////			return new ArrayList<>(groups.values());
////		}
////	}
//
//	static class Solution {
//		class Node {
//			int id;
//			int dist;
//			Node (int id, int d) {
//				this.id = id;
//				this.dist = d;
//			}
//		}
//
//		private static void dijkstra(int s, int[] dist) {
//			PriorityQueue<Node> pq = new PriorityQueue<>();
//
//			pq.offer(new Node(s, 0));
//			dist[s] = 0;
//
//			while (pq.size() != 0) {
//				Node top = pq.poll();
//				int u = top.u;
//				int w = top.w;
//				for (int i = 0; i < graph.get(u).size(); i++) {
//					Node neighbor = graph.get(u).get(i);
//
//					if (w + neighbor.dist < dist[neighbor.id]) {
//						dist[neighbor.id] = w + neighbor.dist;
//						pq.offer(new Node(neighbor.id, dist[neighbor.id]));
//					}
//				}
//			}
//		}
//
//		public int networkDelayTime(int[][] times, int N, int K) {
//			List<List<Node>> graph = new ArrayList<>();
//			int ans = Integer.MIN_VALUE;
//
//			for (int i = 0; i < N; i++) {
//				graph.add(i, new ArrayList());
//			}
//
//			for (int[] time: times) {
//				int u = time[0];
//				int v = time[1];
//				int w = time[2];
//				Node node = new Node(v, w);
//				graph.get(u).add(node);
//			}
//
//			int[] dist = new int[N];
//			Arrays.fill(dist, Integer.MAX_VALUE);
//			dijkstra(K, dist);
//
//			for (int d: dist) {
//				ans = Math.max(ans, d);
//			}
//
//			return ans == Integer.MAX_VALUE ? -1 : ans;
//		}
//	}
//}
