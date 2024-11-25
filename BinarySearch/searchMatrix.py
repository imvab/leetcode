from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        end = len(matrix) - 1
        start = 0

        while (start < end):
            mid = (start + end) // 2

            if (matrix[mid][-1] > target):
                end = mid
            elif (matrix[mid][-1] < target):
                start = mid + 1
            else:
                return True

        s, e = 0, len(matrix[0]) - 1

        while (s <= e):
            mid = (s + e) // 2

            if (matrix[start][mid] > target):
                e = mid - 1
            elif (matrix[start][mid] < target):
                s = mid + 1
            else:
                return True
        return False


        