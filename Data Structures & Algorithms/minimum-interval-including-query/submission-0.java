class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        int[] results = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int min = Integer.MAX_VALUE;
            boolean minUpdated = false;

            for(int j = 0; j < intervals.length; j++){

                int[] current = intervals[j];

                if(current[0] <= queries[i] && queries[i]  <= current[1]){
                    int length = current[1] - current[0] + 1;
                    min = Math.min(length, min);
                    minUpdated = true;
                }
            }

            results[i] = minUpdated ? min : -1;
        }

        return results;
    }
}
