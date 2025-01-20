package array.math;

//LeetCode 1094. Car Pooling

/*
There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi]
indicates that the ith trip has numPassengersi passengers and the locations to pick them up and
drop them off are fromi and toi respectively.
The locations are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers for all the given trips,
or false otherwise.

Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false

Example 2:

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
* */

public class CarPooling {

    public static boolean carPooling(int[][] trips, int capacity) {
        int[] stops = new int[1001];

        for(int[] trip : trips){
            stops[trip[1]] += trip[0];
            stops[trip[2]] -= trip[0];
        }

        int passengerCount = 0;
        for(int val: stops){
            passengerCount += val;
            if(passengerCount > capacity){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {{2,1,5},{3,3,7}};
        int capacity = 4;
        boolean result = carPooling(trips, capacity);
        System.out.println(result);
    }
}
