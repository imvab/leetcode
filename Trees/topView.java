class qObj {
    Node node;
    int level;

    qObj(Node n, int l) {
        node = n;
        level = l;
    }
}

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    public static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        // creating empty queue for level order traversal.
        Queue<qObj> q = new LinkedList<qObj>();
        q.add(new qObj(root, 1));

        // creating a map to store nodes at a particular horizontal distance.
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

        while (!q.isEmpty()) {
            qObj popped = q.poll();
            if (!map.containsKey(popped.level))
                map.put(popped.level, popped.node.data);

            // if left child of popped.node exists, pushing it in
            // the queue with the horizontal distance.
            if (popped.node.left != null)
                q.add(new qObj(popped.node.left, popped.level - 1));

            // if right child of popped.node exists, pushing it in
            // the queue with the horizontal distance.
            if (popped.node.right != null)
                q.add(new qObj(popped.node.right, popped.level + 1));
        }

        // traversing the map and storing the nodes in list
        // at every horizontal distance.
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            ans.add(e.getValue());
        }

        // returning the output list.
        return ans;
    }
}

// https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1