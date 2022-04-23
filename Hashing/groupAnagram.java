import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class App {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        List<List<String>> result = new ArrayList<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            String sorted = new String(arr);

            if (hm.containsKey(sorted)) {
                ArrayList<String> list = hm.get(sorted);
                list.add(s);
                hm.put(sorted, list);
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(s);
                hm.put(sorted, list);
            }
        }

        for (String s : hm.keySet()) {
            result.add(hm.get(s));
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] strs = new String[n];

        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }

        List<List<String>> res = groupAnagrams(strs);

        for (List<String> s : res) {
            for (String r : s) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }
}
