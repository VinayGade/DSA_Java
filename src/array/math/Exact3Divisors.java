package array.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exact3Divisors {

    static List<Integer> exactly3Divisors(int N) {

        List<Integer> nums = new ArrayList<>();
        int count = 0;
        // Iterate from 2 to sqrt(N) to find prime numbers
        int limit = (int) Math.sqrt(N);
        //for (int i = 2; (i*i) <= num; i++) {
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                // If i^2 is less than or equal to N, increment count
                nums.add(i);
                count++;
            }
        }
        return nums;
    }

    // Function to check if a number is prime
    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        // Check divisibility from 2 to sqrt(num)
        int limit = (int) Math.sqrt(num);
        //for (int i = 2; (i*i) <= num; i++) {
        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        /*
        N = 6
        Output: 1
        * */
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        List<Integer> numbers = exactly3Divisors(N);
        System.out.println("\n numbers with exactly 3 divisors:");
        for(int x: numbers)
            System.out.print(x+" ");
        int count = numbers.size();
        System.out.println("\n numbers count = "+count);
    }
}
