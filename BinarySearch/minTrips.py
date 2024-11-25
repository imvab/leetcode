class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        l, r = 0, time[0] * totalTrips
        res = -1

        while l <= r:
            mid = (l + r) // 2

            trips = 0
            for t in time:
                trips += mid // t

            if (trips < totalTrips):
                l = mid + 1
            else:
                res = mid
                r = mid - 1
        return res

# https://leetcode.com/problems/minimum-time-to-complete-trips/