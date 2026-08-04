class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);

            if(current == '[' || current == '('
            || current == '{' ){
                st.push(current);
            }
            else if(!st.isEmpty()){
                    char top = st.peek();
                    if (current == '}' && top == '{'
                    || current == ']' && top == '['
                    || current == ')' && top == '(')
                    {
                        st.pop();
                    }else{
                        return false;
                    }                    
            }else{
                return false;
            }
        }

        return st.isEmpty();
    }

}
