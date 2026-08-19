class Solution {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Diameter passing through this node
        diameter = Math.max(
            diameter,
            leftHeight + rightHeight
        );

        // Return height to parent
        return 1 + Math.max(leftHeight, rightHeight);
    }
}