class MinStack {

    static class Pair {
        int val;
        int min;
        Pair(int val, int min) {
            this.val = val;
            this.min = min;
        }
        int getMin() {
            return this.min;
        }
        int getVal() {
            return this.val;
        }
    }

    private Stack<Pair> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        int newMin = val;
        if (!this.stack.isEmpty())
            newMin = Math.min(val, this.stack.peek().getMin());
        this.stack.push(new Pair(val, newMin));
    }
    
    public void pop() {
        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek().getVal();
    }
    
    public int getMin() {
        return this.stack.peek().getMin();
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