class Solution {
    int count = 0;
    int answer = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return answer;
    }

    public void inorder(TreeNode root, int k) {

        if (root == null) {
            return;
        }

        // Go left
        inorder(root.left, k);

        // Visit root
        count++;

        if (count == k) {
            answer = root.val;
            return;
        }

        // Go right
        inorder(root.right, k);
    }
}