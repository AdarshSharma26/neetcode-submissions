class Pair{
    int ele;
    int min;

    public Pair(int ele, int min){
        this.ele = ele;
        this.min = min;
    }
}

class MinStack {
    Stack<Pair> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(!st.isEmpty()){
            Pair top = st.peek();
            int min = Math.min(top.min, val);
            st.push(new Pair(val, min));
        }else{
            st.push(new Pair(val, val));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().ele;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}
