class Solution {
    public boolean isSymmetric(TreeNode root) {
        // An empty tree is inherently symmetric
        if (root == null) {
            return true;
        }
        // Initiate mirror validation on the left and right subtrees
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        // Base case: both reach null at the same time (symmetric)
        if (left == null && right == null) {
            // Both are null
            return true;
        }
        // One child is missing while the other exists (not symmetric)
        if (left == null || right == null) {
            // Mismatched structure
            return false;
        }
        // Structural values must match, and outer/inner branches must mirror
        return (left.val == right.val)
            && isMirror(left.left, right.right)   // Outer children mirror each other
            && isMirror(left.right, right.left);  // Inner children mirror each other
    }
}
