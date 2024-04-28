package greedy;

import java.util.Arrays;

// LeetCode 881. Boats to Save People
/*
You are given an array people where people[i] is the weight of the ith person,
and an infinite number of boats where each boat can carry a maximum weight of limit.
Each boat carries at most two people at the same time, provided the sum of
the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)

Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)

Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
* */
public class Boats2SavePeople {

    public static int numRescueBoats(int[] people, int limit) {

        //sort people by weight
        Arrays.sort(people);
        int boats = 0;

        //2 pointers -> heaviest, lightest
        int left = 0;
        int right = people.length-1;

        while(left<=right){

            // pair(heaviest, lightest) in same boat
            if(people[left] + people[right] <= limit)
                left++;

            right--;

            //increment number of boats
            boats++;
        }
        return boats;
    }
    public static void main(String[] args) {

        int[] weights = {3,2,2,1};
        int limit = 3;
        System.out.println("minimum boats to save people: "+numRescueBoats(weights, limit));
    }
}
