class Solution {
    int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;

        if (root == null) {
            return -1;
        }

        if (root.left != null) {
            int left = kthSmallest(root.left, this.k);

            if (left != -1) {
                return left;
            }
        }

        this.k--;

        if (this.k == 0) {
            return root.val;
        }

        if (root.right != null) {
            return kthSmallest(root.right, this.k);
        }

        return -1;
    }
}