class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;

        for(int i = 0; i < heights.length; i++){

            int width = getNextSmallerIndex(heights, i) - getPrevSmallerIndex(heights, i) - 1;
            int area = heights[i] * width;
            
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;

    }

    private int getPrevSmallerIndex(int[] heights, int currentIndex){

        int prevSmallerIndex = -1;

        int left = currentIndex - 1;

        while(left >= 0){
            if(heights[currentIndex] > heights[left]){
                prevSmallerIndex = left;
                
                return prevSmallerIndex;
            }

            left--;
        }

        return prevSmallerIndex;
    }

    private int getNextSmallerIndex(int[] heights, int currentIndex){
        int nextSmallerIndex = heights.length;

        int right = currentIndex + 1;

        while(right < heights.length){
            if(heights[currentIndex] > heights[right]){
                nextSmallerIndex = right;
                
                return nextSmallerIndex;
            }
            
            right++;
        }

        return nextSmallerIndex;
    }
}
