package array.math.overlapping_intervals;

import java.util.Arrays;
import java.util.Comparator;

// LeetCode 252 : N meetings in one room

/*
You are given timings of n meetings in the form of (start[i], end[i]) where
start[i] is the start time of meeting i and end[i] is the finish time of meeting i.
Return the maximum number of meetings that can be accommodated in a single meeting room,
when only one meeting can be held in the meeting room at a particular time.

Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

Input: n = 6, start[] = [1, 3, 0, 5, 8, 5], end[] =  [2, 4, 6, 7, 9, 9]
Output: 4
Explanation: Maximum four meetings can be held with given start and end timings.
The meetings are - (1, 2), (3, 4), (5,7) and (8,9)

Input: n = 3, start[] = [10, 12, 20], end[] = [20, 25, 30]
Output: 1
Explanation: Only one meetings can be held with given start and end timings.

* */

/*
Given an array of meeting time intervals where intervals[i] = [starti, endi],
determine if a person could attend all meetings.

Input: intervals = [[0,30],[5,10],[15,20]]
Output: false

Input: intervals = [[7,10],[2,4]]
Output: true
*
* */
class Meeting {
    int start;
    int end;

    Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals.length; ++i) {
            int[] a = intervals[i - 1];
            int[] b = intervals[i];
            if (a[1] > b[0]) {
                return false;
            }
        }
        return true;
    }

    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        Meeting[] meetings = new Meeting[n];

        for(int i=0; i<n; i++){
            meetings[i] = new Meeting(start[i], end[i]);
        }

        Arrays.sort(meetings, Comparator.comparingInt(a -> a.end));

        int count = 1;
        int endTime = meetings[0].end;

        for(int i=1; i<n; i++){
            if(meetings[i].start > endTime){
                count++;
                endTime = meetings[i].end;
            }
        }

        return count;
    }
}
