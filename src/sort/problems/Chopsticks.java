package sort.problems;

import java.util.Arrays;
import java.util.Scanner;

public class Chopsticks {

    /* CodeChef: Chopsticks

     The two sticks in a pair of chopsticks need not be of the same length.
     A pair of sticks can be used to eat as long as the difference in their length is at most D.
      The Chef has N sticks in which the ith stick is L[i] units long.
      A stick can't be part of more than one pair of chopsticks.
      Help the Chef in pairing up the sticks to form the maximum number of usable pairs of chopsticks.


    input:
    5 2
1
3
3
9
4

    Output:
    2

    *
    * */

    public static void main(String[] args) throws Exception
    {
        /*
        i.  Sort array L
        ii. i = 0, j = 1
        ii. while( j < n ){
                if((L[j] - L[i]) <= D){
                    pair++
                    i+=2
                    j+=2
                }
            }
        iii. return pair
        */

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int D = scan.nextInt();

        int[] L = new int[N];
        for (int i = 0; i < N; i++) {
            L[i] = scan.nextInt();
        }
        int pairs = countPair(L, D, N);
        System.out.println(pairs);
    }

    static int countPair(int[] L, int D, int n) {
        Arrays.sort(L);
        int pairs = 0;
        int i = 0;
        while (i < (n - 1)) {
            if ((L[i + 1] - L[i]) <= D) {
                pairs++;
                i += 2;
            } else
                i++;
        }
        return pairs;
    }
}
