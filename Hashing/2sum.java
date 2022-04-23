import java.util.HashMap;
import java.util.Scanner;

public class App {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {

                res[0] = hm.get(target - nums[i]);
                res[1] = i;
                return res;
            } else {
                // key is not found in the hashmap
                hm.put(nums[i], i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int target = sc.nextInt();

        int[] result = twoSum(arr, target);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}