class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        while (true) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            k--;
            if (k == 0) return root.val;
            root = root.right;
        }
    }
}