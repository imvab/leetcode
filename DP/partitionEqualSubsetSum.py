class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        if (sum(nums) % 2 == 1):
            return False

        dp = set()
        dp.add(0)
        target = sum(nums) // 2
        for i in range(len(nums) - 1, -1, -1):
            newDp = set()
            for val in dp:
                if val + nums[i] == target:
                    return True
                newDp.add(val + nums[i])
                newDp.add(val)
            dp = newDp

        return True if target in dp else False
                
# https://neetcode.io/problems/partition-equal-subset-sum

        