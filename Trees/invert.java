class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
        }
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (q.peek() != null) {
            TreeNode x = q.poll();

            // swapping
            TreeNode left = x.left;
            x.left = x.right;
            x.right = left;

            if (x.right != null)
                q.offer(x.right);
            if (x.left != null)
                q.offer(x.left);
        }

        return root;
    }
}