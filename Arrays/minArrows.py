class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        if (len(points) <= 1):
            return len(points)

        balloons = sorted(points, key=lambda x: x[1])
        arrows = 1

        extreme = balloons[0][1]

        for i in range(1, len(balloons)):
            if (extreme >= balloons[i][0]):
                continue
            else:
                arrows += 1
                extreme = balloons[i][1]

        return arrows


# https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons