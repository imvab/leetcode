class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        // in combination sum1 problem as candidates array was given here we will create
        // array
        // and as question saying only numbers from 1 to 9 are used, we will create a
        // array of these numbers
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        backtracking(arr, n, 0, new ArrayList<Integer>(), k);
        return ans;
    }

    // backtracking function below is exactly same as combination sum1 problem
    // but as question saying that we have to take combination of k numbers
    // so we will add list in our ans only when its size is k
    public void backtracking(int candidates[], int target, int rejected, ArrayList<Integer> list, int k) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            // if list size is k then only add it in final list
            if (list.size() == k)
                ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = rejected; i < candidates.length; i++) {
            list.add(candidates[i]);
            // also as we have to use each number only one's so we are taking rejected as
            // i+1
            backtracking(candidates, target - candidates[i], i + 1, list, k);
            list.remove(list.size() - 1);
        }
    }
}