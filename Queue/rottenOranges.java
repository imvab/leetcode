class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<int[]>();
        int m = grid.length; // rows
        int n = grid[0].length; // cols

        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++; // counting fresh oranges
                } else if (grid[i][j] == 2) { // rotten
                    q.offer(new int[] { i, j }); // enqueue
                }
            }
        }

        if (fresh == 0)
            return 0;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int minute = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] current_coordinate = q.poll(); // dequeue
                for (int j = 0; j < directions.length; j++) {
                    int x = current_coordinate[0] + directions[j][0];
                    int y = current_coordinate[1] + directions[j][1];

                    if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 1)
                        continue;

                    grid[x][y] = 2; // marking as rotten
                    fresh--;
                    q.offer(new int[] { x, y });
                }
            }

            if (q.size() == 0 && fresh > 0) {
                return -1;
            }
            minute++;
        }
        if (fresh == 0) {
            return --minute;
        }
        return -1;
    }
}