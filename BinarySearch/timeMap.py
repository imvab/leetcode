from collections import defaultdict
class TimeMap:

    def __init__(self):
        self.d = defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key in self.d:
            self.d[key].append((value, timestamp))
        else:
            self.d[key] = []
            self.d[key].append((value, timestamp))

    def get(self, key: str, timestamp: int) -> str:
        res, values = "", self.d[key]
        l = 0
        r = len(values) - 1

        while (l <= r):
            mid = (l + r) // 2
            if (values[mid][1] <= timestamp):
                res = values[mid][0]
                l = mid + 1
            else:
                r = mid - 1
        return res
