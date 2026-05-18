class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
         int n = position.length;
        if (n == 0) return 0;

        // 1. Create a 2D array to pair position and calculated time to target
        // Pair structure: [position, time]
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        // 2. Sort cars by starting position in descending order (closest to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double currentFleetTime = 0.0;

        // 3. Iterate through sorted cars
        for (int i = 0; i < n; i++) {
            // If the current car takes MORE time than the fleet ahead of it,
            // it cannot catch up. It becomes the leader of a new fleet.
            if (cars[i][1] > currentFleetTime) {
                fleets++;
                currentFleetTime = cars[i][1]; // Update the bottleneck time
            }
            // If it takes LESS or EQUAL time, it merges into the fleet ahead
        }

        return fleets;
    }
}
