class Solution {
    // Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Long> st = new Stack<>();
        long[] result = new long[n];

        // result[n - 1] = -1;
        // st.push(arr[n - 1]);

        for (int i = n - 1; i >= 0; i--) { // from second last to first
            while (!st.isEmpty() && st.peek() < arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                result[i] = -1;
                st.push(arr[i]);
            } else {
                result[i] = st.peek();
                st.push(arr[i]);
            }
        }
        return result;
    }
}

// https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1#