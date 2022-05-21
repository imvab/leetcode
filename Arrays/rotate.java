import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();

        int[] arr = new int[n];
        int[] queries = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int i = 0; i < q; i++)
            queries[i] = sc.nextInt();

        k = k % n;

        for (int i = 0; i < k; i++) {
            int tmp = arr[n - 1];

            for (int j = n - 2; j >= 0; j--)
                arr[j + 1] = arr[j];

            arr[0] = tmp;
        }

        for (int i = 0; i < q; i++)
            System.out.println(arr[queries[i]]);
    }
}
