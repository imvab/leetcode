class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        if (len(nums) == 0):
            return []

        start = nums[0]
        prev = nums[0]
        end = None
        res = []
        for i in range(1, len(nums)):
            if (prev + 1 == nums[i]):
                prev = nums[i]
                end = nums[i]
            else:
                if (end == None):
                    res.append(str(start))
                else:
                    res.append(str(start) + "->" + str(end))
                
                if (i < len(nums)):
                    start = nums[i]
                    end = None
                    prev = start

        if (end == None):
            res.append(str(start))
        else:
            res.append(str(start) + "->" + str(end))
        return res

# https://leetcode.com/problems/summary-ranges/