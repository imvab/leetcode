class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int arr[] = new int[days[n - 1] + 1];

        // Travelling everyday with 1 day ticket
        for (int i = 0; i < n; i++)
            arr[days[i]] = costs[0];

        // Loop to check if weekly or monthly pass will reduce cost
        for (int i = 1; i < days[n - 1] + 1; i++) {
            if (arr[i] == 0) {
                arr[i] = arr[i - 1];
            } else {
                // I travelled on that day
                int x = Math.max(0, i - 7);
                int temp = Math.min(arr[i - 1] + costs[0], arr[x] + costs[1]);
                x = Math.max(0, i - 30);
                temp = Math.min(temp, arr[x] + costs[2]);

                arr[i] = temp;
            }
        }

        return arr[days[n - 1]];
    }
}

// https://leetcode.com/problems/minimum-cost-for-tickets/