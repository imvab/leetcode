class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // if there are no dependencies between courses return true
        if (prerequisites.length == 0)
            return true;

        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        // populate the adjecency map with empty lists
        for (int i = 0; i < numCourses; i++) {
            adjMap.put(i, new ArrayList<>());
        }

        // calculate in dgree and alos populate the adj list
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            adjMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        LinkedList<Integer> stack = new LinkedList<>();
        // add courses with no dependency to stack
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                stack.add(i);
        }

        int count = 0;
        // iterate through stack
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            count++;
            for (int course : adjMap.get(curr)) {
                // reduce the dependency count of the course dependent on current course
                inDegree[course]--;
                // if there are no dependency on dependent course , add it to stack
                if (inDegree[course] == 0)
                    stack.add(course);
            }
        }
        return count == numCourses;

    }
}