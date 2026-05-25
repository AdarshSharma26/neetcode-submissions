class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int count = 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] first = intervals[0];

        for(int i = 1; i < n; i++){

            if(first[1] > intervals[i][0]){
                count++;

                if(intervals[i][1] < first[1]){
                    first = intervals[i];
                }
            }else{
                first = intervals[i];
            }
        }

        return count;
    }
}
