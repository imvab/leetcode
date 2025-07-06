class Solution:
    def checkValidString(self, s: str) -> bool:
        left = []
        star = []

        for i, x in enumerate(s):
            if (x == '('):
                left.append(i)
            elif (x == '*'):
                star.append(i)
            else:
                if not left and not star:
                    return False
                if left:
                    left.pop()
                else:
                    star.pop()

        while left and star:
            if (left.pop() > star.pop()):
                return False


        return not left

            
        