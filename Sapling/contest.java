import java.util.Arrays;
import java.util.Scanner;

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

class Main {
    static int countMakers(int N, int a, int b, int c, int d) {
        if (a == N || b == N || c == N || d == N)
            return 1;
        if (a * b == N || a * c == N || a * d == N || b * c == N || b * d == N || c * d == N)
            return 2;
        if (a * b * c == N || a * b * d == N || a * c * d == N || b * c * d == N)
            return 3;
        return 4;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int d = input.nextInt();
        System.out.print(countMakers(N, a, b, c, d));
    }
}

class GFG {

    // method - returns true if the input is a happy
    // number else returns false
    static boolean isHappynumber(int n) {
        if (n == 1 || n == 7)
            return true;
        int sum = n, x = n;

        // this loop executes till the sum of square of
        // digits obtained is not a single digit number
        while (sum > 9) {
            sum = 0;

            // this loop finds the sum of square of digits
            while (x > 0) {
                int d = x % 10;
                sum += d * d;
                x /= 10;
            }
            if (sum == 1)
                return true;
            x = sum;
        }
        if (sum == 7)
            return true;
        return false;
    }

    // Driver code
    public static void main(String[] args) {
        int n = 13;
        if (isHappynumber(n))
            System.out.println(n +
                    " is a Happy number");
        else
            System.out.println(n +
                    " is not a Happy number");
    }

}

    static boolean isHappyNumber(int n) {
        HashSet<Integer> st = new HashSet<>();
        while (true) {
            n = numSquareSum(n);
            if (n == 1)
                return true;
            if (st.contains(n))
                return false;
            st.add(n);
        }
    }

static int numSquareSum(int n)
{
    int squareSum = 0;
    while (n!= 0)
    {
        squareSum += (n % 10) * (n % 10);
        n /= 10;
    }
    return squareSum;
}