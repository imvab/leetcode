public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return traverse(root, 0, sum);
    }

    public boolean traverse(TreeNode root, int carry, int sum) {
        if (root == null)
            return false;

        if (root.right == null && root.left == null) {
            return sum == root.val + carry;
        }

        carry += root.val;
        boolean l = traverse(root.left, carry, sum);
        boolean r = traverse(root.right, carry, sum);

        return l || r;
    }
}