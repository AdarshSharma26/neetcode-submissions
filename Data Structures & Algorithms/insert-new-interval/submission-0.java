class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;    
        int i = 0;

        List<int[]> results = new ArrayList<>();

        while(i < n && intervals[i][1] < newInterval[0]){
            results.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        results.add(newInterval);

        while(i < n) {
            results.add(intervals[i]);
            i++;
        }

        return results.toArray(new int[results.size()][]);
    }
}
