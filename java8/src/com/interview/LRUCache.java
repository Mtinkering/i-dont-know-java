package com.interview;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {
	public static void main(String[] args) {
		LRUCache cache = new LRUCache( 2 /* capacity */ );


		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));

//		cache.put(3, 3);    // evicts key 2
//		cache.get(2);       // returns -1 (not found)
//		cache.put(4, 4);    // evicts key 1
//		cache.get(1);       // returns -1 (not found)
//		cache.get(3);       // returns 3
//		cache.get(4);       // returns 4
	}

	class Node {
		int val, key;
		Node next, prev;
		public Node(int k, int v) {
			val = v;
			key = k;
		}
	}

	private int capacity;
	private Node head;
	private Node tail;
	private Map<Integer, Node> map = new HashMap<>();



	public LRUCache(int capacity) {
		List<Integer> q = new ArrayList<>();


		this.capacity = capacity;
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}

		Node node = map.get(key);
		remove(node);
		insert(node);
		return node.val;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			remove(map.get(key));
		}
		if (capacity == map.size()) {
			remove(head.next);
		}
		insert(new Node(key, value));
	}

	private void remove(Node node) {
		map.remove(node.key);
		node.prev.next = node.next;
		node.next.prev = node.prev;
		node.prev = null;
		node.next = null;
	}

	private void insert(Node node) {
		map.put(node.key, node);
		Node tailPrev = tail.prev;

		tailPrev.next = node;
		node.next = tail;
		node.prev = tailPrev;
		tail.prev = node;
	}

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */