class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        for i, s in enumerate(s2):
            if (s in s1):
                if (sorted(s2[i:i+len(s1)]) == sorted(s1)):
                    return True
        return False
        