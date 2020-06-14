package com.interview;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

// Default java pq is min heap
public class Heap {
	private static class MaxHeapComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	}

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(3);
//
//		pq.offer(1);
//		pq.offer(2);
//		pq.offer(3);
		System.out.println(pq.size());

		System.out.println(pq);
		Integer x = pq.peek();

//
//		Iterator<Integer> it = pq.iterator();
//		while (it.hasNext()) {
//			System.out.println(pq.poll());
//		}
//
//		pq.toArray();
	}
}
