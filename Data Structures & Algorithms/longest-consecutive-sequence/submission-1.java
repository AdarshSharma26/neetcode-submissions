class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length < 1) return 0;
        
        Arrays.sort(nums);
        int n = nums.length;

        int count = 1;
        int maxCount = 1;
        for (int i = n - 1; i > 0; i--) {
            int difference = nums[i] - nums[i - 1];
            if (difference == 1) {
                count += 1;
            } else if (difference == 0) {
                continue;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }

        return Math.max(count, maxCount);
    }
}
