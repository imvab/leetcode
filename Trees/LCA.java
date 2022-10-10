class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val > root.val && q.val > root.val)
                root = root.right;
            else if (p.val < root.val && q.val < root.val)
                root = root.left;
            else {
                return root;
            }
        }
        return root;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val && q.val < root.val) { // p and q on left side
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) { // p and q on right side
            return lowestCommonAncestor(root.right, p, q);
        }
        return root; // one on left another on right OR only one present OR connected
    }
}

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/