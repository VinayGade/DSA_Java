package sort.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Hotel Bytelandia : CodeChef
/*

A holiday weekend is coming up, and Hotel Bytelandia needs to find out
 if it has enough rooms to accommodate all potential guests.
 A number of guests have made reservations. Each reservation consists of
 an arrival time, and a departure time.
 The hotel management has hired you to calculate the maximum number of guests
 that will be at the hotel simultaneously.
 Note that if one guest arrives at the same time another leaves,
 they are never considered to be at the hotel simultaneously (see the second example).

 input:
 3
3
1 2 3
4 5 6
5
1 2 3 4 5
2 3 4 5 6
7
13 6 5 8 2 10 12
19 18 6 9 9 11 15

output:
3
1
3
*
* */
public class Bytelandia {

    public static void main(String[] args) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        while (t-- > 0) {
            int n = scan.nextInt();
            int[] arrival = new int[n];
            int[] departure = new int[n];

            for (int i = 0; i < n; i++) {
                arrival[i] = scan.nextInt();
            }
            for (int i = 0; i < n; i++) {
                departure[i] = scan.nextInt();
            }
            int guestCount = countGuests(arrival, departure, n);
            System.out.println(guestCount);
        }
    }

    public static int countGuests(int[] a, int[] d, int n) {
        /*
        Algorithm:
        step 1. Create 'events' for each arrival and departure time.
        step 2. sort events.
                if 2 events have same times, departure is processed
                before arrivals.

        step 3.  iterate through these sorted events, updating the      current number of guests and tracking the maximum number   of guests.
        */

        // Create events for arrivals and departures
        List< int[] > events = new ArrayList< >();
        for (int i = 0; i < n; i++) {
            events.add(new int[] {
                    a[i], 1
            }); // Arrival event
            events.add(new int[] {
                    d[i], -1
            }); // Departure event
        }

        // Sort events - primary by time, secondary by type
        // (departure before arrival if same time)

        events.sort((e1, e2) -> (e1[0] != e2[0]) ?
                (e1[0] - e2[0]) : (e1[1] - e2[1])
        );

        int currentGuests = 0;
        int maxGuests = 0;

        // process events
        for(int[] event: events){
            currentGuests += event[1];
            maxGuests = Math.max(maxGuests, currentGuests);
        }
        return maxGuests;
    }
}
