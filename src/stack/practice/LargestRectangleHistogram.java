package stack.practice;

/*
LeetCode 84: Largest Rectangle in Histogram
CodeChef : company-prep

Given an array of integers heights representing the histogram's bar height where
the width of each bar is 1, return the area of the largest rectangle in the histogram.

Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Input: heights = [2,4]
Output: 4

CodeChef
Input:
3
4
2 6 8 4
4
5 10 5 2
2
5 5

output:
12
15
10
*
* */

import java.util.Scanner;
import java.util.Stack;

public class LargestRectangleHistogram {

    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int k = 0; k < t; k++) {
            int N = scanner.nextInt();
            long[] A = new long[N];
            for (int i = 0; i < N; i++)
                A[i] = scanner.nextLong();

            Stack<Integer> S = new Stack<>();
            S.push(-1);
            long res = 0;
            for (int i = 0; i < N; i++) {
                int x = (int) A[i];
                while (S.peek() != -1 && A[S.peek()] >= x) {
                    int y = S.pop();
                    res = Math.max(res, A[y] * (i - 1 - S.peek()));
                }
                S.push(i);
            }
            while (S.peek() != -1) {
                int y = S.pop();
                res = Math.max(res, A[y] * (N - 1 - S.peek()));
            }
            System.out.println(res);
        }
    }

    public static int largestRectangleArea(int[] height) {
        int maxArea = largestRectangleArea(height, height.length);
        return maxArea;
    }
    static int largestRectangleArea(int[] A, int N) {

        Stack<Integer> S = new Stack<>();
        S.push(-1);
        int res = 0;
        for (int i = 0; i < N; i++) {
            int x = (int) A[i];
            while (S.peek() != -1 && A[S.peek()] >= x) {
                int y = S.pop();
                res = Math.max(res, A[y] * (i - 1 - S.peek()));
            }
            S.push(i);
        }
        while (S.peek() != -1) {
            int y = S.pop();
            res = Math.max(res, A[y] * (N - 1 - S.peek()));
        }
        return res;
    }

    // Using Dynamic Programming
    public static int largestRectangleArea(int n, int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;

            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }

    public int largestRectangleHistogram(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        return getMax(heights, 0, heights.length);
    }
    int getMax(int[] heights, int s, int e) {
        if (s + 1 >= e) return heights[s];
        int min = s;
        boolean sorted = true;
        for (int i = s; i < e; i++) {
            if (i > s && heights[i] < heights[i - 1]) sorted = false;
            if (heights[min] > heights[i]) min = i;
        }
        if (sorted) {
            int max = 0;
            for (int i = s; i < e; i++) {
                max = Math.max(max, heights[i] * (e - i));
            }
            return max;
        }
        int left = (min > s) ? getMax(heights, s, min) : 0;
        int right = (min < e - 1) ? getMax(heights, min + 1, e) : 0;
        return Math.max(Math.max(left, right), (e - s) * heights[min]);
    }
}
