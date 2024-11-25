class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        s = []
        res = [0] * len(temperatures)

        for i in range(len(temperatures) - 1, -1, -1):
            while (len(s) > 0 and temperatures[s[-1]] <= temperatures[i]):
                s.pop()
            if (len(s) > 0):
                res[i] = s[-1] - i
            else:
                res[i] = 0
            s.append(i)
        return res
        