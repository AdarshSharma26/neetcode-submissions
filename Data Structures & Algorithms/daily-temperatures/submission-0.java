class Pair{
    int temp;
    int index;

    public Pair(int temp, int index){
        this.temp = temp;
        this.index = index;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        Stack<Pair> st = new Stack<>();
        int[] result = new int[n];

        for(int i = n - 1; i >= 0; i--){
            
            while(!st.isEmpty() && st.peek().temp <= temperatures[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                result[i] = st.peek().index - i;
            }else{
                result[i] = 0;
            }
            
            st.push(new Pair(temperatures[i], i));
        }

        return result;
    }
}
