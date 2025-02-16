package search.practice.hackerrank.leaderboard;

import java.util.ArrayList;
import java.util.Arrays;

/*
Allocate Books

Given an array of integers A of size N and an integer B.

The College library has N books. The ith book has A[i] number of pages.

You have to allocate books to B number of students so that the maximum number of pages
allocated to a student is minimum.

A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
Calculate and return that minimum possible number.

NOTE: Return -1 if a valid assignment is not possible.

Example Input
Input 1:
A = [12, 34, 67, 90]
B = 2
Input 2:
A = [5, 17, 100, 11]
B = 4

Example Output
Output 1:
113
Output 2:
100

Example Explanation
Explanation 1:
There are two students. Books can be distributed in following fashion :
1)  [12] and [34, 67, 90]
    Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
2)  [12, 34] and [67, 90]
    Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
3)  [12, 34, 67] and [90]
    Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
    Of the 3 cases, Option 3 has the minimum pages = 113.
* */

public class BooksAllocation {

    public static int books(ArrayList<Integer> a, int b) { // b = number of students
        int n = a.size();

        // Edge case: If books are fewer than students
        if (n < b)
            return -1;

        int low = Integer.MIN_VALUE, high = 0;

        // Determine search space boundaries
        for (int pages : a) {
            low = Math.max(low, pages); // Minimum possible pages a student gets
            high += pages; // Maximum possible pages a student gets
        }

        int result = high;

        // Binary Search on Answer
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(a, b, mid)) {
                result = mid;  // Store the result
                high = mid - 1; // Try to minimize further
            } else {
                low = mid + 1; // Increase threshold
            }
        }
        return result;
    }

    // Helper function to check if allocation is possible for a given maxPages
    private static boolean isPossible(ArrayList<Integer> a, int b, int maxPages) {
        int students = 1, allocatedPages = 0;

        for (int pages : a) {
            if ((allocatedPages + pages) > maxPages) {
                students++; // New student required
                allocatedPages = pages; // Start new allocation

                if (students > b)
                    return false; // Too many students needed
            } else {
                allocatedPages += pages; // Continue allocation
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(12, 34, 67, 90));
        int B = 2;
        int count = books(A, B);
        System.out.println(count);
    }
}
