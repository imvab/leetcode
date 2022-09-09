class Solution {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        int start = 0;
        // we will be initializing start=0 as we are comparing from left top corner of
        // the matrix

        int end = grid[0].length - 1;
        // end is refering to right top corner of the matrix

        while (start < grid.length && end >= 0) {
            if (grid[start][end] < 0) {
                // if the top left element is negative then we simply add the whole column to
                // the answer and decrease the column by 1 and again check
                ans += grid.length - start;
                end--;
            } else {
                start++;
                // if element is positive then we simply increment the row as it is given the
                // row is sorted which means if we found a positive number then all the numbers
                // left to it will be positive
            }

        }
        return ans;

    }
}