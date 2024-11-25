class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        prefix = { 0 : 1}
        currSum = 0

        for num in nums:
            currSum += num
            if (currSum - k) in prefix:
                count += prefix[currSum - k]

            if (currSum in prefix):
                prefix[currSum] += 1
            else:
                prefix[currSum] = 1
        return count
        
# https://leetcode.com/problems/subarray-sum-equals-k/