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

    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), 1 + hm.getOrDefault(s.charAt(i), 0));
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (hm.containsKey(c)) {
                hm.put(c, hm.get(c) - 1);
            } else {
                return false;
            }
        }

        for (int val : hm.values()) {
            if (val != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        System.out.println(isAnagram(s, t));
    }
}