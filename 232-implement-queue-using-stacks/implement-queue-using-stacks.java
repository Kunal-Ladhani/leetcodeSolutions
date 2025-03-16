class MyQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }
    
    // TC = O(N)
    public void push(int x) {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
    
    // TC = O(1)
    public int pop() {
        return stack1.isEmpty() ? -1 : stack1.pop();
    }
    
    // TC = O(1)
    public int peek() {
        return stack1.isEmpty() ? -1 : stack1.peek();
    }
    
    // TC = O(1)
    public boolean empty() {
        return stack1.isEmpty();
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