package array.math;

//LeetCode 42 Trapping Rain Water

/*
Given n non-negative integers representing an elevation map where the width of each bar=1,
compute how much water it can trap after raining.

ex 1.
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by
array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
6 units of rain water (blue section) are being trapped.

ex 2.
Input: height = [4,2,0,3,2,5]
Output: 9

* */

public class TrappingRainWater {

    public static int trap(int[] height) {
        int n = height.length;
        int[] maxToLeft = new int[n];
        int[] maxToRight = new int[n];

        maxToLeft[0] = height[0];
        for(int i=1; i<n; i++)
            maxToLeft[i] = Math.max(height[i], maxToLeft[i-1]);

        maxToRight[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--)
            maxToRight[i] = Math.max(height[i], maxToRight[i+1]);

        int water = 0;
        for(int i=1; i<n; i++)
            water += (Math.min(maxToLeft[i], maxToRight[i])) - height[i];

        return water;
    }

    public static int trapRainWater(int[]heights) {
        int totalWater = 0;
        int leftPointer = 0;
        int rightPointer = heights.length - 1;
        int leftBound = 0;
        int rightBound = 0;
        // Fill in the rest of this method with your solution

        while(leftPointer < rightPointer){
            if(heights[leftPointer] <=
                    heights[rightPointer]){
                leftBound = Math.max(leftBound, heights[leftPointer]);
                totalWater += leftBound - heights[leftPointer];
                leftPointer++;
            }else{
                rightBound = Math.max(rightBound, heights[rightPointer]);
                totalWater += rightBound - heights[rightPointer];
                rightPointer--;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] height = {1,0,2,1,0,1,3,2,1,2,1};
        int water = trap(height);
        System.out.println("Trapped Rain water = "+water);

        int[] heights = {4, 2, 1, 3, 0, 1, 2};
        int trappedWater = trapRainWater(heights);
        System.out.println("Rain water = "+trappedWater);
    }
}
