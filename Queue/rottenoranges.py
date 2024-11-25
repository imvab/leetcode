class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = collections.deque()
        time = 0
        fresh = 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    fresh += 1
                elif grid[i][j] == 2:
                    q.append((i, j))
        
        directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]

        while (fresh > 0 and q):
            length = len(q)
            for i in range(len(q)):
                rotten = q.popleft()
                for x, y in directions:
                    if (rotten[0] + x in range(len(grid)) and rotten[1] + y in range(len(grid[0]))):
                        if (grid[rotten[0] + x][rotten[1] + y] == 1):
                            grid[rotten[0] + x][rotten[1] + y] = 2
                            q.append((rotten[0] + x, rotten[1] + y))
                            fresh -= 1
            time += 1

        return time if fresh == 0 else -1

        