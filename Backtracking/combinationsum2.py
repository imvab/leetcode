class Solution:
    def combinationSum2(self, nums: List[int], target: int) -> List[List[int]]:
        res = set()
        nums.sort()

        def dfs(i, curr, total):
            if (total == target):
                res.add(tuple(curr))
                return

            if (i >= len(nums) or total > target):
                return

            dfs(i + 1, curr, total)
            curr.append(nums[i])
            dfs(i + 1, curr, total + nums[i])
            curr.pop()
        
        dfs(0, [], 0)
        return [list(combination) for combination in res]