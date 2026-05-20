class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int high = 0;
        int minTime = Integer.MAX_VALUE;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            int time = 0;

            for (int i = 0; i < n; i++) {
                time += (piles[i] + mid - 1) / mid;
            }

            if (time <= h) {
                minTime = Math.min(minTime, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return minTime;
    }
}
