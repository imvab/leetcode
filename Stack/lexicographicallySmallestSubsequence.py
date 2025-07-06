class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        stack = []
        seen = set()
        occurence = {c: i for i, c in enumerate(s)}

        for i, c in enumerate(s):
            if c not in seen:
                while stack and stack[-1] > c and i < occurence[stack[-1]]:
                    seen.discard(stack.pop())

                stack.append(c)
                seen.add(c)
        return "".join(stack)
             