import java.util.Scanner;
import java.util.Stack;

public class App {

    public static boolean isEqual(char a, char b) {
        if (a == '(' && b == ')') {
            return true;
        }

        if (a == '{' && b == '}') {
            return true;
        }

        if (a == '[' && b == ']') {
            return true;
        }

        return false;
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{' || c == '(' || c == '[') {
                st.push(c);
            } else {
                if (!st.isEmpty()) {
                    char x = st.pop();
                    if (!isEqual(x, c))
                        return false;
                } else {
                    return false;
                }
            }
        }
        if (st.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(isValid(s));
    }
}