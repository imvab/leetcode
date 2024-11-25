class Solution:
    def nextPermutation(self, arr: List[int]) -> None:
        n = len(arr)
        i = n - 2
        
        while i >= 0 and arr[i] >= arr[i+1]:
            i -= 1
        
        if i < 0:
            arr.reverse()
            return arr
        j = n - 1
        
        while j >= 0 and arr[j] <= arr[i]:
            j -= 1
        arr[i], arr[j] = arr[j], arr[i]
        arr[i+1:n] =  arr[i+1:n][::-1]
        return arr
        
# https://leetcode.com/problems/next-permutation/

# 637546