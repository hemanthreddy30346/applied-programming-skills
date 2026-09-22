class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, result);

        return result;
    }

    public void dfs(TreeNode root, int targetSum,
                    List<Integer> path,
                    List<List<Integer>> result) {

        if (root == null) {
            return;
        }

        // Add current node
        path.add(root.val);

        // Check leaf
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                result.add(new ArrayList<>(path));
            }
        } else {
            int remaining = targetSum - root.val;

            dfs(root.left, remaining, path, result);
            dfs(root.right, remaining, path, result);
        }

        // Remove current node while going back
        path.remove(path.size() - 1);
    }
}