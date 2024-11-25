class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key = lambda i : i[0])
        res = [intervals[0]]

        for s, e in intervals[1:]:
            end = res[-1][1]

            if s <= end:
                res[-1][1] = max(e, end)
            else:
                res.append([s, e])
        return res
        