package array.math.two_pointers;

import java.util.Arrays;
import java.util.Scanner;

/*
* * * CodeChef : Maximum Common Elements

Given two arrays A and 𝐵 each of size 𝑁
where each array consists of distinct elements.

Find the number of elements that are common in both the arrays.

* * */
//input
/*
3
4
1 2 3 4
1 3 4 5
3
2 4 1
1 4 2
1
2
3

output:
3
3
0
* */
public class    MaximumCommonElements {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0) {
            int N = scan.nextInt();
            int[] a = new int[N];
            int[] b = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = scan.nextInt();
            }
            for (int i = 0; i < N; i++) {
                b[i] = scan.nextInt();
            }
            //Binary Search
            /*
            Arrays.sort(b);
            int count = countMaximumCommonElements(a, b, N);
            */
            //2 - Pointer
            int count = countCommonElements2Ptr(a, b, N);
            System.out.println(count);
        }
    }

    /* Method 1 : Binary Search
    1. sort arr B.
    2. count = 0;   ... initialize counter
    3. for(x: A){
            if(binarySearch(B, x)
                count++;
       }
    4. return count;
    * */
    static int countMaximumCommonElements(int[] a, int[] b, int n){
        int count = 0;
        for(int x: a){
            if(binarySearch(b, n, x))
                count++;
        }
        return count;
    }

    static boolean binarySearch(int[] b, int n, int key){
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(key == b[mid])
                return true;
            else if(key < b[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }

    /* Method 2 : 2 Pointer
    1. sort arr A, B.
    2. count = 0;   ... initialize counter
       (i, j) = 0   ... 2 Pointer
    3. while(i < N && j < N){      // |A| == |B| == N
            if(A[i] == B[j]){
                count++;
                i++;
                j++;
            }else if(A[i] < B[j])
                i++;
            else
                j++;
       }
    4. return count;
    * */

    static int countCommonElements2Ptr(int[] A, int[] B, int N){

        Arrays.sort(A);
        Arrays.sort(B);
        int count = 0;
        int i = 0;
        int j = 0;
        while(i < N && j < N){      // |A| == |B| == N
            if(A[i] == B[j]){
                count++;
                i++;
                j++;
            }else if(A[i] < B[j])
                i++;
            else
                j++;
        }
        return count;
    }
}