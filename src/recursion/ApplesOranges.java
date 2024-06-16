package recursion;

import java.util.Scanner;

public class ApplesOranges {

    /*
    Rushitote went to a programming contest to distribute apples and oranges to the contestants.
    He has N apples and M oranges, which need to be divided equally amongst the contestants.
    Find the maximum possible number of contestants such that:
    i. Every contestant gets an equal number of apples
    ii.Every contestant gets an equal number of oranges.

    Note that every fruit with Rushitote must be distributed, there cannot be any left over.

    For example, 2 apples and 4 oranges can be distributed equally to two contestants,
    where each one receives 1 apple and 2 oranges.

    However, 2 apples and 5 oranges can only be distributed equally to one contestant.

    input:
    3
1 5
2 4
4 6

Output:
1
2
2
    *
    * */

    public static void main (String[] args) throws Exception
    {
        // HCF or GCD

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int n = scanner.nextInt();  // | apples |
            int m = scanner.nextInt();  // | oranges |

            //count of contestants
            int count = gcd(n, m);
            System.out.println(count);
        }
    }

    public static int gcd(int n, int m){

        // if m=0, n is the GCD
        if (m == 0)
            return n;

            // call the gcd() method recursively by
            // replacing n with m and m with
            // modulus(n,m) as long as m != 0
        else
            return gcd(m, n % m);
    }
}
