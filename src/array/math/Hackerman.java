package array.math;

import java.util.Scanner;

/*
CodeChef

Hackerman wants to know who is the better player between Bob and Alice with the help of a game.

The game proceeds as follows:
1. First, Alice throws a die and gets the number A
2. Then, Bob throws a die and gets the number B

Alice wins the game if the sum on the dice is a prime number and Bob wins otherwise.
Who wins the game?

input:
3
2 1
1 1
2 2

output:
Alice
Alice
Bob
* */

public class Hackerman {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (--T >= 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int sum = a + b;
            String winner = isPrime(sum) ? "Alice" : "Bob";
            System.out.println(winner);
        }
    }

    static boolean isPrime(int n) {
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
