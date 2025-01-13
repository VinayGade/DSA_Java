package array.math.two_pointers;

//CodeChef: Stack and Queues: Maximum water in a section

/*
Chef owns a swimming pool with width N meters which contains N continuous walls with height h
(possible zero) and width 1 meter each.

When it rains heavily, water is stored in the swimming pool in the form of sections
(check Figure 1). Chef is busy calling his friends for a party.
So, you need to determine the maximum water stored in a section among all
the sections after a heavy rain.
* */

/*
eg:
input:
2
4
5 0 2 6
6
3 1 4 0 3 5

output:
8
5
* */

//LeetCode 11. Container With Most Water

/*You are given an integer array height of length n.
There are n vertical lines drawn such that the two endpoints of the ith line are
(i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that
the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 In this case, the max area of water (blue section) the container can contain is 49.
*/

/*
GFG: Container With Most Water:

Given an array arr[] of non-negative integers, where each element arr[i] represents
the height of the vertical lines, find the maximum amount of water that can be contained
between any two lines, together with the x-axis.

Note: In the case of a single vertical line it will not be able to hold water.

Input: arr[] = [1, 5, 4, 3]
Output: 6
Explanation: 5 and 3 are 2 distance apart. So the size of the base is 2.
Height of container = min(5, 3) = 3. So, total area to hold water = 3 * 2 = 6.

Input: arr[] = [3, 1, 2, 4, 5]
Output: 12
Explanation: 5 and 3 are 4 distance apart. So the size of the base is 4.
Height of container = min(5, 3) = 3. So, total area to hold water = 4 * 3 = 12.

Input: arr[] = [2, 1, 8, 6, 4, 6, 5, 5]
Output: 25
Explanation: 8 and 5 are 5 distance apart. So the size of the base is 5.
Height of container = min(8, 5) = 5. So, the total area to hold water = 5 * 5 = 25.
* */

import java.util.Scanner;
import java.util.Stack;

public class MaximumWaterSection {

    static int maxWaterSection(int[] height, int n) {
        if (n <= 2) return 0; // No room for water if less than 2 walls

        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int maxWater = 0;
        int currentWater = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                    currentWater = 0;
                } else
                    currentWater += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                    currentWater = 0;
                } else
                    currentWater += rightMax - height[right];
                right--;
            }

            maxWater = Math.max(maxWater, currentWater);
            //currentWater = 0; // Reset current water for new section
        }
        return maxWater;
    }

    static int maxWaterInSection(int[] height, int n) {
        Stack<Integer> stack = new Stack<>();
        int maxWater = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                int currentWater = distance * boundedHeight;
                maxWater = Math.max(maxWater, currentWater);
            }
            stack.push(i);
        }

        return maxWater;
    }

    // LeetCode 11: Container with the most water      // most optimized 2 Pointer
    public static int maxArea(int[] height) {
        int water = 0;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            int leftMax = height[left];
            int rightMax = height[right];
            water = Math.max( water, (right-left) * Math.min(leftMax, rightMax));     // max(curr_water, (width * height))

            if(leftMax <= rightMax){
                while(left < right && leftMax >= height[left])
                    left++;
            }else{
                while(left < right && rightMax >= height[right])
                    right--;
            }
        }
        return water;
    }

    // easiest 2 pointer approach  ...Time Complexity : O(N)
    static int maxArea_simplified(int[] height){
        int maxWater = 0;
        int left = 0, right = height.length - 1;
        while(left < right){
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int water = width * minHeight;
            maxWater = Math.max(maxWater, water);

            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return maxWater;
    }

    //worst case
    int maxArea_BruteForce(int[] height){
        int water = 0;
        for(int i=0; i < height.length; i++){
            for(int j = i+1; j < height.length; j++){
                int w = j-i;
                int currentWater = w * Math.min(height[i], height[j]);
                water = Math.max(water, currentWater);
            }
        }
        return water;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int N = scanner.nextInt();
            int[] height = new int[N];

            for (int i = 0; i < N; i++)
                height[i] = scanner.nextInt();

            int water = maxWaterInSection(height, N);
            System.out.println(water);
        }

        int[] heights = {1,8,6,2,5,4,8,3,7};
        int containerWithMostWater = maxArea(heights);
        System.out.println("containerWithMostWater ="+containerWithMostWater);
    }
}
