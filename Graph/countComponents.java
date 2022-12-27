class Solution {
    void dfs(ArrayList<ArrayList<Integer>> M, int[] visited, int i) {
        for (int j = 0; j < M.size(); j++) {
            if (i != j && M.get(i).get(j) == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    int components(ArrayList<ArrayList<Integer>> adj, int N) {

        int[] visited = new int[adj.size()];
        int count = 0;
        for (int i = 0; i < adj.size(); i++) {
            if (visited[i] == 0) {
                dfs(adj, visited, i);
                count++;
            }
        }
        return count;
    }
}

// https://course.acciojob.com/idle?question=ea0ba181-faaa-4ec3-89d2-c40d022b321f
