class Solution {
    public boolean isMirrorImage(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true; // both are null at that place
        if (p == null || q == null)
            return false; // one tree has no node at that place

        if (p.val != q.val)
            return false; // value mismatch

        return isMirrorImage(p.left, q.right) && isMirrorImage(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirrorImage(root, root);
    }
}

// https://leetcode.com/problems/symmetric-tree/