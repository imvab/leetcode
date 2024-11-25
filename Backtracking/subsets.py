class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []

        def backtrack(i, curr):
            if (i == len(nums)):
                res.append(curr.copy())
                return

            # take
            backtrack(i + 1, curr)
            curr.append(nums[i])
            backtrack(i + 1, curr)
            curr.pop()

        backtrack(0, [])
        return res
            
        