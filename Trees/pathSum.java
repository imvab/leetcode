class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return sum * 10 + root.val;

        return pathSum(root.left, sum * 10 + root.val) + pathSum(root.right, sum * 10 + root.val);
    }

    public int sumNumbers(TreeNode root) {
        return pathSum(root, 0);
    }
}

// https://leetcode.com/problems/sum-root-to-leaf-numbers/