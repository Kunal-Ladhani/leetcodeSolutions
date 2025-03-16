class MyStack {

    private Deque<Integer> queue1;
    private Deque<Integer> queue2;

    public MyStack() {
        this.queue1 = new ArrayDeque<>();
        this.queue2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if (this.queue1.isEmpty())
            this.queue1.add(x);
        else {
            while(!this.queue1.isEmpty()) {
                this.queue2.add(this.queue1.pop());
            }
            this.queue1.add(x);
            while(!this.queue2.isEmpty()) {
                this.queue1.add(this.queue2.pop());
            }
        }
    }
    
    public int pop() {
        return this.queue1.isEmpty() ? -1 : this.queue1.pop();
    }
    
    public int top() {
        return this.queue1.isEmpty() ? -1 : this.queue1.peek();
    }
    
    public boolean empty() {
        return this.queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */