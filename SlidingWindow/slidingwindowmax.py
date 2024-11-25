class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res = []
        q = collections.deque()

        for i in range(len(nums)):
            val = nums[i]

            if (q and q[0] < i - k + 1):
                q.popleft()
            
            while (q and val >= nums[q[-1]]):
                q.pop()

            q.append(i)

            print(q)

            if (i - k + 1 >= 0):
                res.append(nums[q[0]])
        return res
