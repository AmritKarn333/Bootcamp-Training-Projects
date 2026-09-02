class Solution {

    private int preIndex;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        inorderMap = new HashMap<>();

        // Store value -> index in inorder
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        preIndex = 0;

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        if (left > right) {
            return null;
        }

        // First element in preorder = root
        int rootValue = preorder[preIndex++];

        TreeNode root = new TreeNode(rootValue);

        // Find root position in inorder
        int mid = inorderMap.get(rootValue);

        // Build left subtree first
        root.left = build(preorder, left, mid - 1);

        // Then right subtree
        root.right = build(preorder, mid + 1, right);

        return root;
    }
}