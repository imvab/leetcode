class MinStack {

    Stack<Pair<Integer, Integer>> s;

    public MinStack() {
        s = new Stack<Pair<Integer, Integer>>();
    }

    public void push(int val) {
        if (s.isEmpty()) {
            Pair p = new Pair<>(val, val);
            s.push(p);
        } else {
            Pair p = new Pair<>(val, Math.min(val, this.getMin()));
            s.push(p);
        }
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        return s.peek().getKey();
    }

    public int getMin() {
        return s.peek().getValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

// https://leetcode.com/problems/min-stack/
