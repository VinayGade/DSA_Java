package array.math;

import java.util.ArrayList;
import java.util.List;

//LeetCode 2951. Find the Peaks

/*
You are given a 0-indexed array mountain.
Your task is to find all the peaks in the mountain array.

Return an array that consists of indices of peaks in the given array in any order.

Notes:

A peak is defined as an element that is strictly greater than its neighboring elements.
The first and last elements of the array are not a peak.
* */
public class PeakElements {

    static List<Integer> findPeaks(int[] mountain) {
        List<Integer> peaks=new ArrayList<>();
        for(int i=1; i<mountain.length-1; i++)
        {
            if(mountain[i]>mountain[i-1] && mountain[i]>mountain[i+1])
            {
                peaks.add(i);
            }
        }
        return peaks;
    }

    public static void main(String[] args) {
        int mountain[] = {1,4,3,8,5};
        List<Integer> peaks = findPeaks(mountain);
        for(int peak: peaks){
            System.out.println(peak);
        }
    }
}
