class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(TreeNode node, int target, List<Integer> path,
                     List<List<Integer>> ans) {
        if (node == null) return;

        path.add(node.val);
        target -= node.val;

        if (node.left == null && node.right == null && target == 0) {
            ans.add(new ArrayList<>(path));
        }

        dfs(node.left, target, path, ans);
        dfs(node.right, target, path, ans);

        path.remove(path.size() - 1);
    }
}