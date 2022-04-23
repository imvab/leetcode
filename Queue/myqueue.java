class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int x = s2.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return x;
    }

    public int peek() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int x = s2.peek();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return x;
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}

// https://leetcode.com/problems/implement-queue-using-stacks/