class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Record frequencies of each task (A-Z)
        int[] frequencies = new int[26];
        for (char c : tasks) {
            frequencies[c - 'A']++;
        }
        
        // Sort to easily find the maximum frequency
        Arrays.sort(frequencies);
        int maxFreq = frequencies[25];
        
        // Calculate chunks created by the highest frequency task
        int minCycles = (maxFreq - 1) * (n + 1);
        
        // Count how many tasks share this maximum frequency
        for (int i = 25; i >= 0; i--) {
            if (frequencies[i] == maxFreq) {
                minCycles++;
            } else {
                break; // Frequencies are sorted, no more matches possible
            }
        }
        
        // The total cycles cannot be less than the actual number of tasks
        return Math.max(tasks.length, minCycles);
    }
}
