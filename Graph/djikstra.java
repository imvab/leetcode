class App {

    public static void djikstra(int[][] mat) {
        int[] res = new int[mat.length];
        boolean[] visited = new boolean[mat.length];

        for (int i = 0; i < mat.length; i++) {
            res[i] = Integer.MAX_VALUE; // Init to Infinity
            visited[i] = false;
        }

        res[0] = 0;

        for (int i = 0; i < mat.length - 1; i++) {
            int minVal = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < mat.length; j++) {
                if (!visited[j] && res[j] < minVal) {
                    minVal = res[j];
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            for (int j = 0; j < mat.length; j++) {
                if (!visited[j] && mat[minIndex][j] != 0 && res[minIndex] != Integer.MAX_VALUE
                        && res[minIndex] + mat[minIndex][j] < res[j]) {
                    res[j] = res[minIndex] + mat[minIndex][j];
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        int[][] matrix = new int[][] { { 0, 5, 0 }, { 0, 0, 6 }, { 10, 0, 0 } };

        djikstra(matrix);
    }
}