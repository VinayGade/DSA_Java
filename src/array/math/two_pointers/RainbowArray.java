package array.math.two_pointers;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RainbowArray {

    // CodeChef : Rainbow Array

    /*
    Chef likes all arrays equally. But he likes some arrays more equally than others.
    In particular, he loves Rainbow Arrays.

        First a1 elements equal 1.
    Next a2 elements equal 2.
    Next a3 elements equal 3.
    Next a4 elements equal 4.
    Next a5 elements equal 5.
    Next a6 elements equal 6.
    Next a7 elements equal 7.
    Next a6 elements equal 6.
    Next a5 elements equal 5.
    Next a4 elements equal 4.
    Next a3 elements equal 3.
    Next a2 elements equal 2.
    Next a1 elements equal 1.
    ai can be any non-zero positive integer.
    There are no other elements in array.
*/
    public static void main (String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0) {
            int N = scan.nextInt();
            int a[] = new int[N];
            for(int i=0; i<N; i++)
                a[i] = scan.nextInt();
            String rainbow = isRainbowArray(a, N) ? "yes": "no";
            System.out.println(rainbow);
        }
    }

    static boolean isRainbowArray(int[] A, int N){

        // Rainbow : 7 colors ... A[] = {} should contain 7 elements

        /*
        Set<Integer> hashSet = new HashSet<>();
        for(int x: A)
            hashSet.add(x);
        */
        /*
        if(hashSet.size() < 7)
            return false;
        else {
            for (int i = 1; i <= 7; i++)
                if(!hashSet.contains(i))
                    return false;
        }*/
        int i = 1;
        //int j = 7;
        int low=0;
        int high=N-1;
        int mid=N/2;
        while(low<high){
            if (A[low] != i || A[mid] != 7 || A[low] != A[high] || (A[low + 1] - A[low]) > 1 || (A[high] - A[high - 1]) > 1)
                return false;
            /*
            if (A[low] != i || A[mid] != j) {
                //|| (A[low+1]!= ++i))
                return false;
            }
            */
            if (A[low] != A[low + 1])
                i++;
            /*
            if(!hashSet.contains(A[low+1]))
                return false;
             */

            if(low==mid || high==mid)
                break;
            /*
            if(A[low]!=A[low+1])
                i++;
            */
            low++;
            high--;
        }
        return true;
    }
    /*

    input:
    3
19
1 2 3 4 4 5 6 6 6 7 6 6 6 5 4 4 3 2 1
14
1 2 3 4 5 6 7 6 5 4 3 2 1 1
13
1 2 3 4 5 6 8 6 5 4 3 2 1

Output:
yes
no
no



The first example satisfies all the conditions.

The second example has 1 element of value 1 at the beginning and 2 elements of value 1 at the end.

The third one has no elements with value 7 after elements with value 6.

    * */
}
