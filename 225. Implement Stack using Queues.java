class MyStack {
    Queue<Integer> q = new ArrayDeque<>();

    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        for(int idx=1; idx<q.size(); idx++){
            q.add(q.remove());
        }
        return q.remove();

    }
    
    public int top() {
        for(int idx=1; idx<q.size(); idx++){
            q.add(q.remove());
        }
        int ans = q.remove();
        q.add(ans);
        return ans;
    }
    
    public boolean empty() {
        return q.size()== 0;
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
