package array.math.two_pointers;

import java.util.Scanner;

/*
*
3
4
3 7 6 4        -> 2    ...operation 1 : [3 1 6 6 4] -> operation 2 : [3 1 6 6 1 3]
5
1 4 5 4 1      -> 0    ... already palindrome
5
1 2 3 4 5      -> 4
* */

public class PalindromeSplitting {

    public static void main (String[] args) throws java.lang.Exception{

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0){
            int N = scan.nextInt();
            int[] a = new int[N];
            for(int i=0; i<N; i++)
                a[i] = scan.nextInt();

            int count = operationsCount(a, N);
            System.out.println(count);
        }
    }

    static int operationsCount(int[] A, int N){
        int low = 0;
        int high = N-1;
        int count = 0;

        while(low < high) {
            if(A[low] == A[high]) {
                low++;
                high--;
            }
            else if(A[high] != A[low]) {
                if(A[low] > A[high]){
                    A[low] -= A[high];
                    high--;
                }
                else{
                    A[high] -= A[low];
                    low++;
                }
                count++;
            }
        }
        return count;
    }

	/*
	static boolean isPalindrome(int[] a, int n){
	    int start = 0;
	    int end = n-1;
	    while(start < end){
	        if(a[start]!=a[end])
	            return false;
	        start++;
	        end--;
	    }
	    return true;
	}
	*/
}
