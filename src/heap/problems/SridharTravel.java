package heap.problems;

// CodeChef: Heap : Sridhar likes Travel

/*
Sridhar was a seasoned traveler. He liked to visit new places.
More than all he was a meticulous planner. This time he was planning to visit Europe.
He wrote down his travel itinerary like as follows:
If he wanted to visit Madrid, Paris, Munich, Warsaw and Kiev in this order,
he would write it down like as:

Madrid Paris 100
Paris Munich 200
Munich Warsaw 150
Warsaw Kiev 120

More formally, if he wanted to go from A to B directly and the price is C dollars,
then he would write   A B C

on a card. Each move was written on a different card. Sridhar was a great planner,
so he would never visit the same place twice.

Just before starting his journey, the cards got shuffled. Help Sridhar figure out
the actual order of the cards and the total cost of his journey.

Input:
1
5
Warsaw Kiev 120
Madrid Paris 100
Munich Warsaw 150
Paris Munich 200

Output:
Madrid Paris 100
Paris Munich 200
Munich Warsaw 150
Warsaw Kiev 120
570

570 = (100 + 200 + 150 + 120)

* */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SridharTravel {

     /*
     Approach:

     i. Identify nodes in the journey. (cities come across the route from A to B )

     ii. Identify source and the destination of the route.

         a.  source =  indegree (Node) == 0  AND  outdegree (Node) == 1  ... journey begins here.

         b.  destination = indegree (Node) == 1  AND  outdegree (Node) == 0  ... journey ends here.

    iii. Sort (arrange) the sequence of nodes starting from "source", ending at "destination".

    iv. Total Cost = sum(C[0..N-1])
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            if (n <= 1) {
                // If there is only one city, no journey is possible; skip to the next test case.
                System.out.println("0");
                continue;
            }

            HashSet < String > destinationCities = new HashSet < > ();
            HashMap < String, String > cityRoutes = new HashMap < > ();
            HashMap < String, Integer > costs = new HashMap < > ();
            long sum = 0;

            for (int i = 0; i < n - 1; i++) {
                String cityFrom = sc.next();
                String cityTo = sc.next();
                int cost = sc.nextInt();

                cityRoutes.put(cityFrom, cityTo);
                destinationCities.add(cityTo);
                costs.put(cityFrom, cost);
                sum += cost;
            }

            String startCity = "";
            for (String city: cityRoutes.keySet()) {
                if (!destinationCities.contains(city)) {
                    startCity = city;
                    break;
                }
            }

            String currentCity = startCity;
            for (int i = 0; i < n - 1; i++) {
                String nextCity = cityRoutes.get(currentCity);
                System.out.println(currentCity + " " + nextCity + " " + costs.get(currentCity));
                currentCity = nextCity;
            }
            System.out.println(sum);
        }
        sc.close();
    }
}
