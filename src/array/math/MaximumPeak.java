package array.math;

import java.util.Scanner;

/*
CodeChef: Maximum Peak

You are given a sequence A1, A2, ... , An.
A peak is a subarray (a contiguous subsequence) of A
whose elements first strictly increase and then strictly decrease in value.

More formally, a subarray from L to R is a peak if and only if there exists an integer
X such that L<=X<=R  for which the subarray from L to X is strictly increasing and
the subarray from X to R is strictly decreasing.

subarrays that are only strictly increasing and subarrays that are only strictly
decreasing are considered peaks as well.

Find the maximum length of a peak in the sequence A.

Input:
4
6
1 3 5 3 1 9
7
3 5 4 7 5 6 3
4
1 5 7 8
3
9 5 1

Output:
5
3
4
3
* */
public class MaximumPeak {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (--T >= 0) {
            int N = scanner.nextInt();
            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = scanner.nextInt();
            }
            int size = findPeakSize(a, N);
            System.out.println(size);
        }
    }

    static int findPeakSize(int[] a, int n){

        int maxPeakLength = 1;
        int peak = 0;
        int currPhase = -2;
        int currPeakLength = 0;

        for(int element: a){
            if(element < peak){
                if(currPhase == -1)
                    currPeakLength++;
                else{
                    currPhase = -1;
                    currPeakLength++;
                }
            }else if(element > peak){
                if(currPhase == 1)
                    currPeakLength++;
                else{
                    if(currPhase == -2)
                        currPeakLength = 1;
                    else
                        currPeakLength = 2;
                    currPhase = 1;
                }
            }else{
                currPhase = 0;
                currPeakLength = 1;
            }
            maxPeakLength = Math.max(maxPeakLength, currPeakLength);
            peak = element;
        }
        return maxPeakLength;
    }
}
