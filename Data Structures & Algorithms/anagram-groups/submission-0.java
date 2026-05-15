class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> hm = new HashMap<>();

       for(String str : strs){
        char[] current = str.toCharArray();
        Arrays.sort(current);

        String key = new String(current);

            if(hm.containsKey(key)){
                List<String> newList = hm.get(key);
                newList.add(str);
            }else{
                hm.put(key, new ArrayList<>(List.of(str)));
            }

       }
       for(Map.Entry<String, List<String>> entry : hm.entrySet()){
            result.add(entry.getValue());
       }

       return result;
    }
}
