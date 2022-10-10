public class Solution {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        int rows = getHeight(root);
        int cols = (int) Math.pow(2, rows) - 1;
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add("");
            }
            res.add(row);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<int[]> indexQ = new LinkedList<>();
        queue.offer(root);
        indexQ.offer(new int[] { 0, cols - 1 });
        int row = -1;
        while (!queue.isEmpty()) {
            row++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                int[] indices = indexQ.poll();

                if (cur == null) {
                    continue;
                }

                int left = indices[0];
                int right = indices[1];
                int mid = left + (right - left) / 2;
                res.get(row).set(mid, String.valueOf(cur.val));

                queue.offer(cur.left);
                queue.offer(cur.right);
                indexQ.offer(new int[] { left, mid - 1 });
                indexQ.offer(new int[] { mid + 1, right });
            }
        }

        return res;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}

class Solution {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new LinkedList<>();
        int height = root == null ? 1 : getHeight(root);
        int rows = height, columns = (int) (Math.pow(2, height) - 1);
        List<String> row = new ArrayList<>();
        for (int i = 0; i < columns; i++)
            row.add("");
        for (int i = 0; i < rows; i++)
            res.add(new ArrayList<>(row));
        populateRes(root, res, 0, rows, 0, columns - 1);
        return res;
    }

    public void populateRes(TreeNode root, List<List<String>> res, int row, int totalRows, int i, int j) {
        if (row == totalRows || root == null)
            return;
        res.get(row).set((i + j) / 2, Integer.toString(root.val));
        populateRes(root.left, res, row + 1, totalRows, i, (i + j) / 2 - 1);
        populateRes(root.right, res, row + 1, totalRows, (i + j) / 2 + 1, j);
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}

// https://leetcode.com/problems/print-binary-tree/