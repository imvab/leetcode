class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < 2 * i; j++) {
                System.out.print(j + " ");
            }
            System.out.println("");
        }

    }
}

class Solution {
    static boolean savePerson(int n, int[] vaccinePigment, int[] personPigment) {
        // Write your code here
        Arrays.sort(personPigment);
        Arrays.sort(vaccinePigment);
        for (int i = 0; i < n; i++) {
            if (vaccinePigment[i] <= personPigment[i]) {
                return false;
            }
        }
        return true;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int x = sc.nextInt();
        System.out.println(minOperations(grid, x));
        sc.close();
    }

    static int f(int[] v, int x, int val) {
        int s = 0;
        int n = v.length;
        for (int i = 0; i < n; i++) {
            s += Math.abs(v[i] - val);
        }
        return s / x;
    }

    static int minOperations(int[][] grid, int x) {
        int[] v = new int[grid.length * grid[0].length];
        int row = grid.length;
        int col = grid[0].length;
        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                v[k++] = grid[i][j];
            }
        }
        Arrays.sort(v);
        int n = v.length;
        for (int i = 1; i < n; i++) {
            if ((v[i] - v[i - 1]) % x != 0)
                return -1;
        }
        int idx = n / 2;
        if (n % 2 == 0) {
            int val1 = v[idx];
            int val2 = v[idx - 1];
            int ans1 = f(v, x, val1);
            int ans2 = f(v, x, val2);
            return Math.min(ans1, ans2);
        } else {
            int val1 = v[idx];
            return f(v, x, val1);
        }
    }
}