package search.practice;

import java.util.Scanner;

/*
CodeChef: Binary Search - Books in Library
N books in library
|books| = N
|students| = A
Number of pages in ith book = Bi
Chef allocates N books to A students in continuous order.
ith student will be allocated contiguous set of books (Bj, Bj+1, ... , Bj+k)
Minimize max count of pages allocated to student.
Find that min value.

Input:
2
5 2
4 8 2 6 10
5 5
10 5 10 12 18

Output:
16
18

Test case 1:
First student will be allocated books [4, 8]
other student will be allocated books [2, 6, 10]
So sum of pages will be 12, 16 and max(12, 16) = 16

Test case 2:
Each student will be allocated one book and maximum of them will be 18

* */

public class BooksInLibrary {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(booksCount(b, n, a));
        }
    }

    static long largest(int[] b, int n) {
        long max = 0;
        for (int i = 0; i < n; i++) {
            max = (long) Math.max(b[i], max);
        }
        return max;
    }

    static long findSum(int[] a) {
        long sum = 0;
        for (int e: a)
            sum += e;
        return sum;
    }

    static boolean isValid(long mid, int students, int[] books) {
        long sum = 0;
        int count = 1;
        for (int pages: books) {
            if (sum + pages > mid) {
                count++;
                sum = pages;
                if (count > students)
                    return false;
            } else
                sum += pages;
        }
        return true;
    }

    static long booksCount(int[] b, int n, int a) {

        if (n == a) {
            return largest(b, n);
        } else {
            long min = largest(b, n);
            long max = findSum(b);
            long answer = max;

            while (min <= max) {
                long mid = min + (max - min) / 2;
                if (isValid(mid, a, b)) {
                    answer = mid;
                    max = mid - 1;
                } else
                    min = mid + 1;
            }
            return answer;
        }
    }
}