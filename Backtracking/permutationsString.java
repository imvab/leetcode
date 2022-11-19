class Solution {
    HashSet<String> res = new HashSet<String>();

    public void swap(char[] arr, int x, int y) {
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public List<String> find_permutation(String S) {
        char[] arr = S.toCharArray();
        // Arrays.sort(arr);
        backtrack(arr, 0, arr.length - 1);
        ArrayList<String> result = new ArrayList(res);
        Collections.sort(result);
        return result;
    }

    public void backtrack(char[] arr, int start, int end) {
        if (start == end) {
            res.add(new String(arr));
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(arr, start, i);
            backtrack(arr, start + 1, end);
            swap(arr, start, i);
        }
    }
}

// https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1