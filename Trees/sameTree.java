class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true; // both are null at that place
        if (p == null || q == null)
            return false; // one tree has no node at that place

        if (p.val != q.val)
            return false; // value mismatch

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// https://leetcode.com/problems/same-tree/