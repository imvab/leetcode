class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = []

        path = path.split('/')

        for i in range(len(path)):
            if (path[i] == ''):
                continue
            elif (path[i] == '.'):
                continue
            elif (path[i] == '..'):
                if (len(stack) > 0):
                    stack.pop()
            else:
                stack.append(path[i])

        res = '/'
        for s in stack:
            res += s + '/'
        
        return res if res == '/' else res[:-1]

# https://leetcode.com/problems/simplify-path/