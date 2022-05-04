class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        // if(root==null)
        q.add(root);
        List<Double> arr = new ArrayList<>();
        double ans = 0.0;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode front = q.remove();
                if (front.left != null) {
                    q.add(front.left);
                }
                if (front.right != null) {
                    q.add(front.right);
                }
                ans += front.val;
            }
            arr.add(ans / n);
            ans = 0;
        }
        return arr;
    }
}