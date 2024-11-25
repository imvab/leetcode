import math

class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        maxPile = max(piles)
        if (h == len(piles)):
            return maxPile

        start = 1
        end = maxPile
        res = None

        while (start <= end):
            rate = (start + end) // 2
            hours = 0
            for pile in piles:
                hours += math.ceil(float(pile) / rate)
            if (hours > h):
                start = rate + 1
            elif (hours <= h):
                res = rate
                end = rate - 1
        return res
        