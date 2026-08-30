class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        int maxStreak = 0;
        for(int num : set){

            if(!set.contains(num - 1)){
                int current = num;
                int currentStreak = 1;

                while(set.contains(current + 1)){
                    current++;
                    currentStreak++;
                }
                
                maxStreak = Math.max(maxStreak, currentStreak);
            }
        }

        return maxStreak;
    }
}
