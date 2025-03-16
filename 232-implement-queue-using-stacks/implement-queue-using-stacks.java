class MyQueue {

    private Deque<Integer> input;
    private Deque<Integer> output;

    public MyQueue() {
        this.input = new ArrayDeque<>();
        this.output = new ArrayDeque<>();
    }
    
    // TC = O(N)
    public void push(int x) {
        this.input.push(x);
    }
    
    // TC = O(1)
    public int pop() {
        // underflow
        if (output.isEmpty() && input.isEmpty()) return -1;

        if (output.isEmpty()) {
            while(!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }
    
    // TC = O(1)
    public int peek() {
        if (output.isEmpty()) {
            while(!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    // TC = O(1)
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */