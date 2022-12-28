class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> g = new HashMap<Integer, ArrayList<Integer>>();
        int[] noDep = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
            g.put(i, new ArrayList<Integer>());

        for (int i = 0; i < prerequisites.length; i++) {
            g.get(prerequisites[i][1]).add(prerequisites[i][0]);
            noDep[prerequisites[i][0]]++;
        }

        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < numCourses; i++) {
            if (noDep[i] == 0)
                st.push(i);
        }

        while (!st.isEmpty()) {
            int curr = st.pop(); // done

            for (int c : g.get(curr)) {
                noDep[c]--;

                if (noDep[c] == 0)
                    st.add(c);
            }
        }

        for (int i = 0; i < noDep.length; i++)
            if (noDep[i] > 0)
                return false;

        return true;
    }
}

// https://leetcode.com/problems/course-schedule/description/