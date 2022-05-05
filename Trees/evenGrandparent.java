class Solution {
    ArrayList<TreeNode> traversal = new ArrayList<TreeNode>();

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            traversal.add(root);
            inOrder(root.right);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return traversal.get(k - 1).val;
    }
}

// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
