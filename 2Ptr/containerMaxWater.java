class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left < right){
            int currentMin = Math.min(height[left], height[right]);
            max = Math.max(max, currentMin * (right - left));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}

// https://leetcode.com/problems/container-with-most-water/