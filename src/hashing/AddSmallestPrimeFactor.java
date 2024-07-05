package hashing;

import java.util.Scanner;

public class AddSmallestPrimeFactor {

    /*
    Chef's current score = X
    Each second, Chef will find the smallest prime factor of his score
    and add it to his score.
    Determine the minimum time in seconds, after which his score becomes >= Y

    X, Y is given
Input:
    4
2 23
9 20
5 100
6 89

Output:
11
5
46
42
    *
    * */

    public static void main(String[] args) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (--T >= 0) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            int time = computeTime(x, y);
            System.out.println(time);
        }
    }

    static int computeTime(int x, int y) {
        int count = 0;
        // If x is odd, we need to make it even
        //while (x < y) {
            int factor = smallestPrimeFactor(x);
            x += factor;
            count++;
        //}

        // Now x is even, so we can simply add 2 in each step
        count += (y - x + 1) / 2;
        return count;
    }

    static int smallestPrimeFactor(int n) {
        if (n % 2 == 0)
            return 2;
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0)
                return i;
        }
        return n;
    }
}
