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
            if (curr.val <= prev) return false;
            prev = curr.val;
            curr = curr.right;
        }
        return true;
    }
}

// https://leetcode.com/problems/validate-binary-search-tree/