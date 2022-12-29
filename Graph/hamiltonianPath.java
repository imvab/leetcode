class Solution {
    boolean dfs(ArrayList<ArrayList<Integer>> adj, int u, int cnt, int N) {
        if (cnt == N)
            return true;
        vis[u] = true;
        for (int i : adj.get(u)) {
            if (!vis[i] && dfs(adj, i, cnt + 1, N))
                return true;
        }
        vis[u] = false;
        return false;
    }

    boolean[] vis;

    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        vis = new boolean[N + 1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> i : Edges) {
            int u = i.get(0);
            int v = i.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for (int i = 1; i < N; i++) {
            if (dfs(adj, i, 1, N))
                return true;
        }
        return false;
    }
}

// https://course.acciojob.com/idle?question=696e11ef-b9f2-4691-889a-2b22d7c97076