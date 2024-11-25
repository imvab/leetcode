class Solution:
    def jump(self, nums: List[int]) -> int:
        end = far = jumps = 0

        for i in range(len(nums) - 1):
            far = max(far, i + nums[i])

            if (i == end):
                jumps += 1
                end = far

        return jumps