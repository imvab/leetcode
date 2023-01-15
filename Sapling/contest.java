class Solution { 
    long birthdayGift(int[] A,int[] B,int N) { 
        //Your code here
        long sum=0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<N;i++){
            sum+=Math.abs(A[i]-B[i]);
        }
        return sum;
    }
}

import java.util.*;

public class Main {
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