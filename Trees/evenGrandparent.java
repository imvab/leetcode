class Solution {
    int sum = 0;

    public void helper(TreeNode child, TreeNode parent, TreeNode grandParent) {
        if (child == null)
            return;

        if (grandParent != null && grandParent.val % 2 == 0)
            sum += child.val;

        helper(child.left, child, parent);
        helper(child.right, child, parent);
    }

    public int sumEvenGrandparent(TreeNode root) {
        helper(root, null, null);
        return sum;
    }
}