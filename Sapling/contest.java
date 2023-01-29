class Solution {
    public static void starPyramid(int n) {

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                if (j == 0 || j == 2 * i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }

    }
}

class Solution {
    long birthdayGift(int[] A, int[] B, int N) {
        // Your code here
        long sum = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < N; i++) {
            sum += Math.abs(A[i] - B[i]);
        }
        return sum;
    }
}

class Solution {
    static boolean check(int n) {
        if (n == 1 || n == 7 || n == 10)
            return true;
        if (n < 10)
            return false;

        int num = 0, temp = 0;
        while (n != 0) {
            temp = (n % 10);
            num += temp * temp;
            n /= 10;
        }
        return check(num);
    }

    static int solve(int n) {
        // code here
        ++n;
        while (true) {
            if (check(n))
                return n;
            else
                ++n;
        }

    }
}