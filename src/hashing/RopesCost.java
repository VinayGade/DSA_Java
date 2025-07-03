package hashing;

import java.util.PriorityQueue;

public class RopesCost {

    // int[] arr = {4, 3, 2, 6};

    /*

     ropes        cost
     [4 5 6]       5
       [9 6]       9
         [15]      15

      total cost = 5 + 9 + 15 = 29

    * */

    // int[] arr = {4, 2, 7, 6, 9};

    /*

   ropes              cost
   [4, 2, 7, 6, 9]     0
      [6  7  6  9]     6
        [12  7  9]    12
           [12 16]    16
              [28]    28

     total cost = 6 + 12 + 16 + 28 = 62

    * */

    public static int minCost(int[] arr) {

        int n = arr.length;

        if(n <= 1)
            return 0;
        // cost to connect 2 ropes = sum of their lengths

        PriorityQueue<Integer> ropes = new PriorityQueue<>();

        int totalCost = 0;
        int[] costs = new int[n-1];

        for(int x: arr){
            ropes.add(x);
        }

        int i=0;
        while(!ropes.isEmpty() && n>1){

            int first = ropes.poll();
            int second = ropes.poll();

            int rope = first + second;
            costs[i] = rope;
            ropes.add(rope);
            i++;
            n--;
        }

        for(int cost: costs){
            totalCost += cost;
        }
        return totalCost;
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 7, 6, 9};

        int totalCost = minCost(arr);

        System.out.println(totalCost);
    }
}
