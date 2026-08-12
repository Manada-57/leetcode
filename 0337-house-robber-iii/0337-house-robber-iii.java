/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        // The answer is the maximum of robbing or skipping the root
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode node) {
        // Base case: empty house returns 0 for both choices
        if (node == null) {
            return new int[]{0, 0}; // [rob_it, skip_it]
        }

        // Recurse down to left and right subtrees
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // Choice 1: Rob this node (must skip children)
        int robIt = node.val + left[1] + right[1];

        // Choice 2: Skip this node (take max of robbing or skipping children)
        int skipIt = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{robIt, skipIt};
    }
}
