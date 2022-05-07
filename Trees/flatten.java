class Solution {
    TreeNode prev = new TreeNode(-1);

    public void flatten(TreeNode root) {
        if (node == null)
            return;
        TreeNode origLeft = node.left, origRight = node.right;
        prev.right = node;
        prev = node;
        flatten(origLeft);
        flatten(origRight);
        node.left = null;
    }
}