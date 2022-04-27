class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        long prev = Long.MIN_VALUE;
        TreeNode curr = root;

        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            if (curr.val <= prev)
                return false;
            prev = curr.val;
            curr = curr.right;
        }
        return true;
    }

    public boolean checkBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {

        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }
}

// https://leetcode.com/problems/validate-binary-search-tree/