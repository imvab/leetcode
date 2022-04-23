class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 3)
            return result;

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            int first = nums[i];

            int target = -first;
            int start = i + 1;
            int end = n - 1;

            while (start < end) {
                int sum = nums[start] + nums[end];

                if (sum > target)
                    end--;
                else if (sum < target)
                    start++;
                else {
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(first);
                    l.add(nums[start]);
                    l.add(nums[end]);

                    result.add(l);

                    while (start < end && nums[start] == nums[start + 1])
                        start++;
                    while (start < end && nums[end] == nums[end - 1])
                        end--;

                    start++;
                    end--;
                }
            }

            while (i < n - 1 && nums[i] == nums[i + 1])
                i++;
        }
        return result;
    }
}

// https://leetcode.com/problems/3sum/