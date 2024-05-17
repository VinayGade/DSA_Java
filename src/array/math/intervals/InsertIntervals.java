package array.math.intervals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
LeetCode 57. Insert Interval

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10

* */

public class InsertIntervals {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        //int n = intervals.length;
        int[][] result = Arrays.copyOf(intervals, intervals.length+1);
        result[result.length - 1]=newInterval;
        return merge(result);
    }

    static int[][] merge(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] interval : intervals){
            if(merged.isEmpty() || merged.getLast()[1] < interval[0])
                merged.add(interval);
            else
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        //intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};

        int[][] result = insert(intervals, newInterval);
        for(int[] interval: result){
            System.out.println(interval[0] + " "+interval[1]);
        }
    }
}
