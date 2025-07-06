class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        pairs.sort(key = lambda x : x[1])

        longest = 1
        end = pairs[0][1]

        for i in range(1, len(pairs)):
            if (end < pairs[i][0]):
                longest += 1
                end = pairs[i][1]

        return longest
        