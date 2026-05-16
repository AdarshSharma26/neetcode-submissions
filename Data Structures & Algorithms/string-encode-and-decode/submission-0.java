class Solution {
    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return "";
        }

        StringBuilder st = new StringBuilder();
        for (String str : strs) {
            st.append(str.length()).append("#").append(str);
        }

        System.out.println(st);
        return st.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

        int i = 0;
        while(i < str.length()){
            int j = i;

            while(str.charAt(j) != '#'){
                j++;
            }

            int length = Integer.parseInt(str.substring(i , j));
            i = j + 1;

            decoded.add(str.substring(i, i + length));

            i+= length;
        }

        return decoded;
    }
}
