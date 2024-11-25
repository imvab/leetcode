class Solution:
    def helper(self, nums: List[int]) -> int:
        house0, house1 = 0, 0

        for house in nums:
            temp = max(house0 + house, house1)
            house0 = house1
            house1 = temp

        return house1

    def rob(self, nums: List[int]) -> int:
        return max(nums[0], self.helper(nums[1:]), self.helper(nums[:-1]))
        