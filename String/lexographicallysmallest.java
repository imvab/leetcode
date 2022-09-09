import java.util.*;

class GFG {

    // Function to find lexicographically
    // smallest subsequence of size K
    static void smallestSubsequence(char[] S, int K) {

        // Length of String
        int N = S.length;

        // Stores the minimum subsequence
        Stack<Character> answer = new Stack<>();

        // Traverse the String S
        for (int i = 0; i < N; ++i) {

            // If the stack is empty
            if (answer.isEmpty()) {
                answer.add(S[i]);
            } else {

                // Iterate till the current
                // character is less than the
                // the character at the top of stack
                while ((!answer.isEmpty())
                        && (S[i] < answer.peek())

                        // Check if there are enough
                        // characters remaining
                        // to obtain length K
                        && (answer.size() - 1 + N - i >= K)) {
                    answer.pop();
                }

                // If stack size is < K
                if (answer.isEmpty() || answer.size() < K) {

                    // Push the current
                    // character into it
                    answer.add(S[i]);
                }
            }
        }

        // Stores the resultant String
        String ret = "";

        // Iterate until stack is empty
        while (!answer.isEmpty()) {
            ret += (answer.peek());
            answer.pop();
        }

        // Reverse the String
        ret = reverse(ret);

        // Print the String
        System.out.print(ret);
    }

    static String reverse(String input) {
        char[] a = input.toCharArray();
        int l, r = a.length - 1;
        for (l = 0; l < r; l++, r--) {
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
        }
        return String.valueOf(a);
    }

    // Driver Code
    public static void main(String[] args) {
        String S = "aabdaabc";
        int K = 3;
        smallestSubsequence(S.toCharArray(), K);
    }
}