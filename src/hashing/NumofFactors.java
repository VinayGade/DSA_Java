package hashing;

import java.util.HashMap;
import java.util.Scanner;

/*
CodeChef: Number of Factors

Alice has learnt factorization recently.
Bob doesn't think she has learnt it properly and hence he has decided to quiz her.
Bob gives Alice a very large number and asks her to find out the number of factors of that number.
To make it a little easier for her, he represents the number as a product of N numbers.
Alice is frightened of big numbers and hence is asking you for help.
Your task is simple. Given N numbers, you need to tell the number of distinct factors
of the product of these N numbers.
* */

public class NumofFactors {

    /*
    Test Case 1:

N = 3
Numbers: 3, 5, 7
Product = 3 * 5 * 7 = 105
Prime factorization of 105: 3^1 * 5^1 * 7^1
Number of distinct factors = (1+1) * (1+1) * (1+1) = 2 * 2 * 2 = 8

Test Case 2:

N = 3
Numbers: 2, 4, 6
Product = 2 * 4 * 6 = 48
Prime factorization of 48: 2^4 * 3^1
Number of distinct factors = (4+1) * (1+1) = 5 * 2 = 10

Test Case 3:

N = 2
Numbers: 5, 5
Product = 5 * 5 = 25
Prime factorization of 25: 5^2
Number of distinct factors = (2+1) = 3
    *
    * */
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // number of test cases

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // number of numbers
            int[] numbers = new int[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = scanner.nextInt();
            }
            long result = countPrimeFactors(numbers, N);
            System.out.println(result);
        }
    }

    static long countPrimeFactors(int[] numbers, int N) {

        // use a HashMap to store the count of each prime facto
        HashMap< Integer, Integer > primeFactorCount = new HashMap < > ();

        for (int num: numbers) {
            int current = num;

            //For each number, factorize it by checking divisibility from 2 upwards.
            for (int p = 2; p * p <= current; p++) {

                /*
                If a number current is is divisible by a prime p  divide current by p until it
                is no longer divisible by p.
                * */
                while (current % p == 0) {
                    primeFactorCount.put(p, primeFactorCount.getOrDefault(p, 0) + 1);
                    current /= p;
                }
            }
            if (current > 1) {
                primeFactorCount.put(current, primeFactorCount.getOrDefault(current, 0) + 1);
            }
        }

        long result = 1;
        for (int count: primeFactorCount.values()) {
            result *= (count + 1);
        }
        return result;
    }
}
