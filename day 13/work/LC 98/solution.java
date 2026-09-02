 class Solution {
    long prev=Long.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return true;
        }
        if (!isValidBST(root.right)){
            return false;
        }
        if (root.val>=prev){
            return false;
        }
        prev=root.val;
        return isValidBST(root.left);
    }
}