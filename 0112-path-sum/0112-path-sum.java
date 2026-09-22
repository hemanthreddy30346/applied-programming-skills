class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        // Check if it is a leaf node
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Subtract current value and check left/right
        int remaining = targetSum - root.val;

        return hasPathSum(root.left, remaining) ||
               hasPathSum(root.right, remaining);
    }
}