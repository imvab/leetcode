class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        left = 0
        total = 0
        res = float('inf')

        for i in range(len(nums)):
            total += nums[i]

            while (total >= target):
                res = min(res, i - left + 1)
                total -= nums[left]
                left += 1

        return res if res != float('inf') else 0

# https://leetcode.com/problems/minimum-size-subarray-sum/