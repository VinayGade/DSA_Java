package sort.problems;

/*

Hotel Bookings Possible

A hotel manager has to process N advance bookings of rooms for the next season.
His hotel has C rooms. Bookings contain an arrival date and a departure date.
He wants to find out whether there are enough rooms in the hotel to satisfy the demand.
Write a program that solves this problem in time O(N log N) .

Note- If we have arrival and departure on the same date then arrival must be served before the departure.

Input 1:

 A = [1, 3, 5]
 B = [2, 6, 8]
 C = 1
Input 2:

 A = [1, 2, 3]
 B = [2, 3, 4]
 C = 2

Output 1:

 0

Output 2:

 1
* */

import java.util.ArrayList;
import java.util.Collections;

public class HotelBooking {

    static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int k) {

        int n = arrive.size();
        Collections.sort(arrive);
        Collections.sort(depart);
        int i=1;
        int j=0;
        int curr=1;
        while(i<n && j<n){
            if(arrive.get(i) < depart.get(j)){
                curr++;
                i++;
                if(curr>k){
                    return false;
                }
            }else if(arrive.get(i) == depart.get(j)){
                curr++;
                if(curr > k)
                    return false;
                i++;
                j++;
            }else{
                curr--;
                if(curr < 0){
                    curr=0;
                }
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(3);
        A.add(5);

        ArrayList<Integer> B = new ArrayList<>();
        B.add(2);
        B.add(6);
        B.add(8);

        int k = 1;
        boolean result = hotel(A, B, k);
        System.out.println(result ? "YES": "NO");
    }
}
