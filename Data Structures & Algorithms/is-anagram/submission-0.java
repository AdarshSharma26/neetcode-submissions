class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        char[] sA = s.toCharArray();
        char[] tA = t.toCharArray();

        Arrays.sort(sA);
        Arrays.sort(tA);

        String sorteds = new String(sA);
        String sortedt = new String(tA);

        return sorteds.equals(sortedt);
    }
}
