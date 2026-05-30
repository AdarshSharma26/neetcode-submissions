class Solution {
    public int maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;

        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int area = Math.min(heights[right], heights[left]) * (right - left);
            maxArea = Math.max(area, maxArea);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
