class Solution {
    boolean isReachable(int s, int d, ArrayList<ArrayList<Integer>> adj, int V, int N) {

        if (s == d)
            return true;

        boolean[] visited = new boolean[V + 2];
        for (int i = 0; i < V + 2; i++)
            visited[i] = false;

        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            s = queue.remove();

            for (int i = 0; i < adj.get(s).size(); i++) {

                if (adj.get(s).get(i) == d)
                    return true;

                if (!visited[adj.get(s).get(i)]) {
                    visited[adj.get(s).get(i)] = true;
                    queue.add(adj.get(s).get(i));
                }
            }
        }

        return false;
    }

    boolean check(int N, int V, ArrayList<ArrayList<Integer>> Edges, int u, int v) {
        // your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> i : Edges) {
            int x = i.get(0);
            int y = i.get(1);
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        return isReachable(u, v, adj, N, V);
    }
}