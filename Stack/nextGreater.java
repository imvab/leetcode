import java.util.Stack;

public class App {

    public static int[] nextGreater(int[] input) {
        int n = input.length;
        int[] output = new int[n];
        output[n - 1] = -1;

        Stack<Integer> st = new Stack<Integer>();
        st.push(input[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() < input[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                output[i] = -1;
                st.push(input[i]);
            } else {
                output[i] = st.peek();
                st.push(input[i]);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 8, 0, 1, 3 };
        int[] op = nextGreater(arr);
        for (int i = 0; i < op.length; i++) {
            System.out.print(op[i] + " ");
        }
        System.out.println();
    }
}

// https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1#