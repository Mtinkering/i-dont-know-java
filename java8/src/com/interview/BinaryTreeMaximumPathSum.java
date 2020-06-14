package com.interview;



public class BinaryTreeMaximumPathSum {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	private int answer = Integer.MIN_VALUE;

//     private int[] helper(TreeNode node) {
//       if (node == null) {

//         return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
//       }

//       int[] left = helper(node.left);
//       int[] right = helper(node.right);

//       int withoutRoot = Math.max(Math.max(Math.max(left[0], left[1]), right[0]), right[1]);

//       if (node.left == null) {
//         left[0] = 0;
//       }
//       if (node.right == null) {
//         right[0] = 0;
//       }

//       int withRoot = Math.max(node.val, left[0] + node.val);
//       withRoot = Math.max(withRoot, right[0] + node.val);
//       withRoot = Math.max(withRoot, node.val + left[0] + right[0]);

//       answer = Math.max(Math.max(answer, withRoot), withoutRoot);

//       System.out.println(node.val);
//       System.out.printf("%d %d",withRoot, withoutRoot);
//       return new int[]{withRoot, withoutRoot};
//     }

	private int helper(TreeNode node) {
		if (node == null) {

			return 0;
		}

		int left = helper(node.left);
		int right = helper(node.right);

		int withRoot = Math.max(node.val, left + node.val);
		withRoot = Math.max(withRoot, right + node.val);

		answer = Math.max(answer, Math.max(withRoot, node.val + left + right));

		if (withRoot < 0 && node.val < 0) {
			return 0;
		}
		// System.out.println(node.val);
		// System.out.printf("%d %d",withRoot, withoutRoot);
		return withRoot;
	}


	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		helper(root);
		return answer;
	}
}
