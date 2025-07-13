package search.practice;

/*
Painter Partition Problem

You are given N boards of varying lengths, and k painters are available to paint these boards.
Each painter takes the same amount of time to paint 1 unit of board length.
A painter can only paint contiguous sections of boards, and each board must be
painted by exactly one painter.

Your task is to determine the minimum time required to paint all the boards
 such that no painter paints more than a specific amount of length.
 You need to divide the boards into k contiguous parts in such a way that
 the maximum length painted by any painter is minimized.

 input:
 3
4 2
10 20 30 40
5 3
10 10 10 10 10
6 1
5 10 15 20 25 30


output:
60
20
105
* */

import java.util.Arrays;
import java.util.Scanner;

public class PainterPartition {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ensure input is available and handled properly
        if (sc.hasNextInt()) {
            int t = sc.nextInt();

            while (t--> 0) {
                if (sc.hasNextInt()) {
                    int N = sc.nextInt();
                    int k = sc.nextInt();
                    int[] boards = new int[N];

                    for (int i = 0; i < N; i++) {
                        if (sc.hasNextInt()) {
                            boards[i] = sc.nextInt();
                        }
                    }
                    System.out.println(painterPartition(boards, k));
                }
            }
        }
        sc.close();
    }

    static int painterPartition(int[] boards, int k) {

        int low = Arrays.stream(boards).max().getAsInt();
        int high = Arrays.stream(boards).sum();
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValidPartition(boards, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static boolean isValidPartition(int[] boards, int k, int maxLength) {
        int paintersRequired = 1, currentLength = 0;

        for (int length: boards) {
            if (currentLength + length > maxLength) {
                paintersRequired++;
                currentLength = length;
                if (paintersRequired > k)
                    return false;
            } else {
                currentLength += length;
            }
        }
        return true;
    }
}
