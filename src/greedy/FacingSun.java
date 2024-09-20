package greedy;

/*
Facing the sun:

Given an array height representing the heights of buildings. You have to count the buildings
that will see the sunrise (Assume the sun rises on the side of the array starting point).
Note: The height of the building should be strictly greater than the height of the buildings
left in order to see the sun.

Input: height = [7, 4, 8, 2, 9]
Output: 3

Input: height = [2, 3, 4, 5]
Output: 4
* */

/*
Greedy Approach:

The first building (leftmost) will always see the sunrise.
Traverse the array from left to right and compare each building's height with
the maximum height encountered so far.
If a building's height is strictly greater than the maximum height,
it can see the sunrise. Increment the count and update the maximum height.

Key Variables:

count: Tracks the number of buildings that can see the sunrise.
max_height: Stores the maximum height encountered while traversing the array.
Time Complexity: The solution runs in O(n) since it makes a single pass through the array.
* */
public class FacingSun {

    // Returns count buildings that can see sunlight
    public static int countBuildings(int[] height) {
        // If no buildings exist, return 0
        if (height == null || height.length == 0) {
            return 0;
        }

        // The first building will always see the sunrise
        int count = 1;
        int max_height = height[0]; // Track the height of the first building

        // Traverse the array from left to right
        for (int i = 1; i < height.length; i++) {
            // If current building is taller than max_height, it can see the sunrise
            if (height[i] > max_height) {
                count++;
                max_height = height[i]; // Update max height seen so far
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] height = {7, 4, 8, 2, 9};
        int count = countBuildings(height);
        System.out.println(count);
    }
}
