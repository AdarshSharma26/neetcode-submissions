class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> results = new ArrayList<>();

        int[] first = intervals[0];

        for(int i = 1; i < n; i++){
            
            if(first[1] >= intervals[i][0]){
                first[1] = Math.max(first[1], intervals[i][1]);
            }else{
                results.add(first);
                first = intervals[i];
            }                        
        }

        results.add(first);

        return results.toArray(new int[results.size()][]);
    }
}
