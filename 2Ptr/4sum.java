class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Set<List<Integer>> res = new HashSet<>();
        if (nums.length == 0)
            return new ArrayList<>(res);

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            for (int j = i + 1; j < nums.length - 2; j++) {

                int k = j + 1;
                int l = nums.length - 1;

                while (k < l) {

                    int sum = nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target)
                        res.add(Arrays.asList(nums[i], nums[j], nums[k++], nums[l--]));
                    else if (sum > target)
                        l--;
                    else if (sum < target)
                        k++;
                }
            }
        }
        return new ArrayList<>(res);
    }
}