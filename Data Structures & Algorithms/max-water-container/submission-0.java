class Solution {
    public int maxArea(int[] heights) {
        
        int maxArea = Integer.MIN_VALUE;

        for(int i = 0; i < heights.length; i++){
            
            int left = i + 1;

            while(left < heights.length){

                int area = Math.min(heights[i], heights[left]) * (left  - i);
                maxArea = Math.max(area, maxArea);
                left++;
            }

        }

        return maxArea;
    }
}
