class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<Integer>();
        int i = 0;

        while (i < asteroids.length) {
            int current = asteroids[i];

            if (s.isEmpty()) {
                s.push(current);
                i++;
            } else {
                int lastAsteroid = s.peek();

                if (lastAsteroid > 0 && current < 0) { // last moving right and current moving left
                    // collision
                    if (Math.abs(current) <= lastAsteroid)
                        i++;
                    if (Math.abs(current) >= lastAsteroid)
                        s.pop();

                } else {
                    // no collision
                    s.push(current);
                    i++;
                }
            }
        }
        int[] result = new int[s.size()];
        for (int c = s.size() - 1; c >= 0; c--)
            result[c] = s.pop();
        return result;
    }
}