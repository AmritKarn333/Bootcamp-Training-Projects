class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        // Node not found
        if (root == null) {
            return null;
        }

        // Search left
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // Search right
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // Found the node
        else {

            // Case 1: no left child
            if (root.left == null) {
                return root.right;
            }

            // Case 2: no right child
            if (root.right == null) {
                return root.left;
            }

            // Case 3: two children
            TreeNode successor = findMin(root.right);

            root.val = successor.val;

            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}