class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        pre = {i:[] for i in range(numCourses)}

        for crs, p in prerequisites:
            pre[crs].append(p)

        res = []
        visited, cycle = set(), set()

        def dfs(crs):
            if crs in cycle:
                return False
            if crs in visited:
                return True

            cycle.add(crs)
            for p in pre[crs]:
                if not dfs(p):
                    return False
            cycle.remove(crs)
            visited.add(crs)
            res.append(crs)
            return True

        for c in range(numCourses):
            if not dfs(c):
                return []
        return res