class Car{
    int position;
    double timeToTarget;

    Car(int position, double timeToTarget){
        this.position = position;
        this.timeToTarget = timeToTarget;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        Car cars[] = new Car[n];

        for(int i = 0; i < n; i++){
            cars[i] = new Car(position[i], (double)(target - position[i])/speed[i]);            
        } 

        Arrays.sort(cars, (a , b) -> a.position - b.position);

        int countFleets = 0;
        double currentFleetTimeToTarget = 0.0;

        for(int i = n - 1; i >= 0; i--){
            if(cars[i].timeToTarget >  currentFleetTimeToTarget){
                countFleets++;
                currentFleetTimeToTarget = cars[i].timeToTarget;
            }
        }

        return countFleets;
    }
}
