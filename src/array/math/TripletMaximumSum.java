package array.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/*
Maximum Sum Triplet:

Given an array A containing N integers.

You need to find the maximum sum of triplet ( Ai + Aj + Ak )
such that
0 <= i < j < k < N
Ai < Aj < Ak.

If no such triplet exist return 0.

* */
public class TripletMaximumSum {

    public static int solve(List<Integer> A) {

        int n = A.size();
        if(n<3)
            return 0;
        else if(n==3){
            int sum = 0;
            for(int x: A){
                sum += x;
            }
            return sum;
        }else{
            // Create an array to store the maximum values on the right of each element
            int[] maxRight = new int[n];
            maxRight[n - 1] = A.get(n - 1);

            for (int i = n - 2; i >= 0; i--) {
                maxRight[i] = Math.max(maxRight[i + 1], A.get(i));
            }

            // Use a TreeSet to keep track of the elements to the left of the current element

            TreeSet<Integer> leftElements = new TreeSet<>();
            int maxSum = 0;

            for (int j = 1; j < n - 1; j++) {
                leftElements.add(A.get(j - 1)); // Add the current left element

                // Check if the current element can form a valid triplet
                if (leftElements.lower(A.get(j)) != null && maxRight[j + 1] > A.get(j)) {
                    int Ai = leftElements.lower(A.get(j));
                    int Aj = A.get(j);
                    int Ak = maxRight[j + 1];

                    maxSum = Math.max(maxSum, Ai + Aj + Ak);
                }
            }
            // Return 0 if no valid triplet was found
            return maxSum;
        }
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(2, 5, 3, 1, 4, 9); //A = [1, 2, 3]
        int sum = solve(A);
        System.out.println(sum);
    }
}
