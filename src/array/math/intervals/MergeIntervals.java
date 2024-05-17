package array.math.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
LeetCode 56. Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping
intervals, and return an array of the non-overlapping intervals that cover
all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
* */

public class MergeIntervals {

    static int[][] merge(int[][] intervals){
        if(intervals.length == 1)
            return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> result = new ArrayList<>();
        int[] mergedInterval = intervals[0];

        result.add(mergedInterval);
        for(int[] interval: intervals){
            if(interval[0] <= mergedInterval[1])
                mergedInterval[1] = Math.max(mergedInterval[1], interval[1]);
            else {
                mergedInterval = interval;
                result.add(mergedInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {{1,3},{2,6},{8,10},{8,9},{9,11},{15,18},{2,4},{16,17}};
        int[][] mergedIntervals = merge(intervals);

        for(int[] interval: mergedIntervals){
            System.out.println(interval[0] + " "+interval[1]);
        }
    }
}
