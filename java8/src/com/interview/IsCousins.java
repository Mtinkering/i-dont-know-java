package com.interview;

import java.util.LinkedList;
import java.util.Queue;

public class IsCousins {
	public boolean isCousins(TreeNode root, int x, int y) {
		// Do BFS
		Queue<TreeNode> q = new LinkedList<>();
		int[] levels = new int[101];
		int xp = -1;
		int yp = -2;
		q.offer(root);
		levels[root.val] = 0;

		while (!q.isEmpty()) {
			TreeNode u = q.poll();
			TreeNode[] children = {u.left, u.right};

			for (TreeNode child: children) {
				if (child != null) {
					q.offer(child);
					if (child.val == x) xp = u.val;
					if (child.val == y) yp = u.val;
					levels[child.val] = levels[u.val] + 1;
				}
			}
		}

		return xp != yp && levels[x] == levels[y];
	}

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
  }
}

// time: O(N)
// space: O(N)

