class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> l = new LinkedList<Integer>();

        for (int i = 0; i < nums.length; i++) {

            if (!l.isEmpty() && l.peek() < i - k + 1) { // not part of curr window
                l.poll();
            }

            while (!l.isEmpty() && nums[i] >= nums[l.peekLast()]) {
                l.pollLast(); // removeRear
            }

            l.offer(i);

            if (i - k + 1 >= 0)
                res[i - k + 1] = nums[l.peek()];
        }

        return res;
    }
}