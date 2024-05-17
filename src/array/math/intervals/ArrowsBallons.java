package array.math.intervals;

//LC 452. Minimum Number of Arrows to Burst Balloons

import java.util.Arrays;

/*
Example 1:

Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].

Example 2:

Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4
Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.

Example 3:

Input: points = [[1,2],[2,3],[3,4],[4,5]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].

*
* */
public class ArrowsBallons {

    public static int findMinArrowShots(int[][] points) {
        if(points.length==0)
            return 0;

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrow = 1;
        int end = points[0][1];
        for(int i=1; i<points.length; i++){
            if(points[i][0] > end){
                arrow++;
                end = points[i][1];
            }
        }
        return arrow;
    }

    public static void main(String[] args) {
        int[][] balloons = {{10,16},{2,8},{1,6},{7,12}};
        int arrowCount = findMinArrowShots(balloons);
        System.out.println(arrowCount);
    }
}
