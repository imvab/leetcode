class Solution {
    public int findJudge(int n, int[][] trust) {
        // If there's only 1 person, they must be the judge.
        if (n == 1)
            return 1;
        // People are numbered starting from 1 but array indices start at 0, so
        // allocate 1 extra element to avoid subtracting 1 all the time.
        var people = new int[n + 1];
        // -1 means we don't have a candidate for judge yet.
        int candidate = -1;
        for (var t : trust) {
            // Decrement the count of the person who trusts (this means they
            // can't be the judge as their count will never reach n-1).
            people[t[0]]--;
            // Increment the count of the person who is trusted and note them
            // as a candidate if their count reaches n-1.
            if (++people[t[1]] == n - 1)
                candidate = t[1];
        }
        // If we have a candidate and their count is still n-1, that's the
        // judge. Otherwise there is no judge.
        return (candidate != -1 && people[candidate] == n - 1) ? candidate : -1;
    }
}

// https://leetcode.com/problems/find-the-town-judge/