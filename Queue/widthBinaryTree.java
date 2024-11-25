class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int max = -1;
        Deque<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            int first = q.peek().pos;
            int last = q.peekLast().pos;
            max = Math.max(max, last - first + 1);
            int size = q.size();
            while (size != 0) {
                Pair p = q.pop();
                if (p.node.left != null)
                    q.offer(new Pair(p.node.left, (p.pos) * 2 + 1));
                if (p.node.right != null)
                    q.offer(new Pair(p.node.right, (p.pos) * 2 + 2));
                size--;
            }
        }
        return max;
    }
}

class Pair {
    TreeNode node;
    int pos;

    public Pair(TreeNode node, int pos) {
        this.node = node;
        this.pos = pos;
    }
}