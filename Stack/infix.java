import java.util.Scanner;
import java.util.Stack;

public class App {

    public static int getPrec(char op) {
        switch (op) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    public static String inToPost(String s) {
        Stack<Character> st = new Stack<Character>();
        String postfix = "";

        for (Character c : s.toCharArray()) {
            if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (st.peek() != '(') {
                    postfix += st.pop();
                }
                st.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                while (!st.isEmpty() && getPrec(c) <= getPrec(st.peek())) {
                    postfix += st.pop();
                }
                st.push(c);
            } else {
                postfix += c;
            }
        }

        while (!st.isEmpty()) {
            postfix += st.pop();
        }

        return postfix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(inToPost(sc.next()));
    }
}