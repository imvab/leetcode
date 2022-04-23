import java.util.Scanner;
import java.util.Stack;

public class App {

    public static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<Character>();

        String res = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (st.isEmpty())
                st.push(c);
            else {
                if (st.peek() == c) {
                    st.pop();
                } else {
                    st.push(c);
                }
            }
        }

        while (!st.isEmpty()) {
            res = st.pop() + res;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("aabbccx"));
    }
}