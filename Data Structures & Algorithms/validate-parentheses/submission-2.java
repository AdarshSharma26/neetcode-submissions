class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        char[] input = s.toCharArray();

        for(int i = 0; i < input.length; i++){

            if(input[i] == '(' || input[i] == '{' || input[i] == '['){
                st.push(input[i]);
            }else{
                if(!st.isEmpty() && (st.peek() == '(' && input[i] == ')' || st.peek() == '{' && input[i] == '}' || st.peek() == '[' && input[i] == ']')){
                    st.pop();
                }else{
                    return false;
                }
            }
        }

        return st.size() > 0 ? false : true;
    }
}
