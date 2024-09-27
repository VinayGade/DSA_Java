package stack.practice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//CodeChef: Stack and Queues:

/*
You are given a list of integers heights representing the heights of N mountain peaks.
For each peak, you need to find the height of the next higher peak that comes after
it in the list.  If there is no higher peak after a given peak, return -1  for that peak.

input:
4
6 5 3 6

output:
-1 6 6 -1

* */
public class MountainPeak {

    public static int[] nextHigherPeak(int[] heights, int n) {

        int[] result = new int[n];
        Arrays.fill(result, -1); // Initialize result array with -1
        Stack< Integer > stack = new Stack < > (); // Stack to store indices

        for (int i = 0; i < n; ++i) {
            // While stack is not empty and the current height is greater than the height at index stored on top of the stack
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = heights[i]; // Set the result for the index
            }
            stack.push(i); // Push current index onto the stack
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];

        for (int i = 0; i < n; ++i) {
            heights[i] = sc.nextInt();
        }

        int peak[] = nextHigherPeak(heights, n);

        for (int x: peak) {
            System.out.print(x + " ");
        }
    }
}
