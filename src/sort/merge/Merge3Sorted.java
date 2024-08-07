package sort.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Merge3Sorted {

    // A[], B[], C[]: input arrays
    // sizes: N, M, P
    //Function to merge three sorted lists into a single list.
    static ArrayList<Integer> merge3sorted(int A[], int B[], int C[])
    {
        // creating an empty list to store sorted numbers
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0, j = 0, k = 0;

        // using merge concept and trying to find
        // smallest of three while all three arrays
        // contains at least one element
        while (i < A.length && j < B.length && k < C.length) {
            int a = A[i];
            int b = B[j];
            int c = C[k];
            if (a <= b && a <= c) {
                list.add(a);
                i++;
            }
            else if (b <= a && b <= c) {
                list.add(b);
                j++;
            }
            else {
                list.add(c);
                k++;
            }
        }
        // next three while loop is to sort two
        // of arrays if one of the three gets exhausted
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                list.add(A[i]);
                i++;
            }
            else {
                list.add(B[j]);
                j++;
            }
        }
        while (j < B.length && k < C.length) {
            if (B[j] < C[k]) {
                list.add(B[j]);
                j++;
            }
            else {
                list.add(C[k]);
                k++;
            }
        }
        while (i < A.length && k < C.length) {
            if (A[i] < C[k]) {
                list.add(A[i]);
                i++;
            }
            else {
                list.add(C[k]);
                k++;
            }
        }

        // if one of the array are left then
        // simply appending them as there will
        // be only largest element left
        while (i < A.length) {
            list.add(A[i]);
            i++;
        }
        while (j < B.length) {
            list.add(B[j]);
            j++;
        }
        while (k < C.length) {
            list.add(C[k]);
            k++;
        }

        return list;
    }

    static ArrayList<Integer> mergeTwo(List<Integer> A, List<Integer> B) {
        // Get sizes of vectors
        int m = A.size();
        int n = B.size();

        // ArrayList for storing Result
        ArrayList<Integer> D
                = new ArrayList<Integer>(m + n);

        int i = 0, j = 0;
        while (i < m && j < n) {

            if (A.get(i) <= B.get(j))
                D.add(A.get(i++));
            else
                D.add(B.get(j++));
        }

        // B has exhausted
        while (i < m)
            D.add(A.get(i++));

        // A has exhausted
        while (j < n)
            D.add(B.get(j++));

        return D;
    }

    static void printSorted(ArrayList<Integer> list)
    {
        for(Integer x : list)
            System.out.print(x + " ");
    }
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- >0)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int A[] = new int[a];
            int B[] = new int[b];
            int C[] = new int[c];

            for(int i = 0; i < a; i++)
                A[i] = sc.nextInt();

            for(int i = 0; i < b; i++)
                B[i] = sc.nextInt();

            for(int i = 0; i < c; i++)
                C[i] = sc.nextInt();

            printSorted(new Merge3Sorted().merge3sorted(A, B, C));
            System.out.println();

        }
    }

    /*
    public static void main (String[] args) {
        Integer[] a = { 1, 2, 3, 5 };
        Integer[] b = { 6, 7, 8, 9 };
        Integer[] c = { 10, 11, 12 };
        List<Integer> A = Arrays.asList(a);
        List<Integer> B = Arrays.asList(b);
        List<Integer> C = Arrays.asList(c);

        // First Merge A and B
        ArrayList<Integer> T = mergeTwo(A, B);

        // Print Result after merging T with C
        ArrayList<Integer> ans = mergeTwo(T, C);
        for (int i = 0; i < ans.size(); i++)
            System.out.print(ans.get(i) + " ");
    }*/
}
