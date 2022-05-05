class Solution {
    int count;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    public void dfs(TreeNode root, int max) {
        if (root == null)
            return;
        if (root.val >= max) {
            max = root.val;
            count += 1;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }
}