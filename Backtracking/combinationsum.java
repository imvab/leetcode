class Solution {
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, target, 0, new ArrayList());
        return res;
    }

    public void backTrack(int[] candidates, int target, int rejected, ArrayList<Integer> list) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList(list));
            return;
        }

        for (int i = rejected; i < candidates.length; i++) {
            list.add(candidates[i]);
            // chek if its taking me to a desired solution
            backTrack(candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1); // actual backtracking
        }
    }
}