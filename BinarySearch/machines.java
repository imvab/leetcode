import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] lifetime = new int[k];
        for (int i = 0; i < k; i++)
            lifetime[i] = sc.nextInt();
        sc.close();
        System.out.println(maxRunTime(n, lifetime));
    }

    private static boolean canFit(int n, long k, int[] lifetime) {
        long currlifeSum = 0;
        long target = n * k;

        for (int life : lifetime) {
            if (life < k) {
                currlifeSum += life;
            } else {
                currlifeSum += k;
            }

            if (currlifeSum >= target) {
                return true;
            }
        }

        return currlifeSum >= target;
    }

    public static long maxRunTime(int n, int[] lifetime) {
        long lifeSum = 0;
        for (int life : lifetime) {
            lifeSum += life;
        }

        long lower = 0;
        long upper = lifeSum / n;
        long res = -1;

        // binary search
        while (lower <= upper) {
            long mid = lower + (upper - lower) / 2;

            if (canFit(n, mid, lifetime)) {
                res = mid;
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }

        return res;
    }
}

// https://course.acciojob.com/idle?question=640e3336-efe0-470c-9d7a-1bb87e588b2e