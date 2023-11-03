package array.math;

import java.util.LinkedList;
import java.util.List;

public class Prime {

    public static void main(String[] args) {

        int N = 100;

        // prime numbers from 1 to n
        List<Integer> primeNumbers = primes(N);

        System.out.println("Prime numbers from 1 to "+N+" are: ");
        for(int prime : primeNumbers)
            System.out.print(" "+prime);

        System.out.println("\n\nPrime numbers from 1 to "+N+" sieve of Eratosthenes: \n");
        sieveOfEratosthenes(N);
    }

    public static List<Integer> primes(int N){

        List<Integer> prime1ToN = new LinkedList<>();

        // Using for loop for traversing all
        // the numbers from 1 to N
        for (int x = 2; x <= N; x++) {

            // Using isPrime flag variable to check
            // if x is prime or not
            boolean isPrime = true;

            for (int y = 2; y * y <= x; y++) {
                if (x % y == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                prime1ToN.add(x);
        }
        return prime1ToN;
    }

    public static void sieveOfEratosthenes(int n)
    {
        // Create a boolean array
        // "prime[0..n]" and
        // initialize all entries
        // it as true. A value in
        // prime[i] will finally be
        // false if i is Not a
        // prime, else true.
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a
            // prime
            if (prime[p]) {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i])
                System.out.print(i + " ");
        }
    }
}
