class Solution {
    HashSet<List<Integer>> res = new HashSet();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target, new ArrayList(), 0);
        return new ArrayList(res);
    }

    public void backTrack(int[] candidates, int target, ArrayList<Integer> list, int rejected) {
        if (target < 0)
            return;
        if (target == 0) {
            ArrayList l = new ArrayList(list);
            // Collections.sort(l);
            res.add(l);
            return;
        }
        for (int i = rejected; i < candidates.length; i++) {
            if (i > rejected && candidates[i] == candidates[i - 1])
                continue;
            list.add(candidates[i]);
            backTrack(candidates, target - candidates[i], list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}