class Solution {
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, -1))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean vis[], int parent) {
        vis[v] = true;
        for (Integer neigh : adj.get(v)) {
            if (!vis[neigh]) {
                if (dfs(neigh, adj, vis, v))
                    return true;
            } else if (parent != neigh)
                return true;
        }
        return false;
    }
}

// https://course.acciojob.com/idle?question=c5f395d4-c8ed-4c3c-88e9-285a189bddca