class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Ignore negative paths
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // Path passing through current node
        int currentPath = node.val + left + right;

        maxSum = Math.max(maxSum, currentPath);

        // Return the best ONE-sided path to parent
        return node.val + Math.max(left, right);
    }
}