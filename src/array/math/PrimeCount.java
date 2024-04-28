package array.math;

//Leetcode 204. Count Primes
//Given an integer n, return the number of prime numbers that are strictly less than n.

/*
Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

Example 2:

Input: n = 0
Output: 0

Example 3:

Input: n = 1
Output: 0
* */
public class PrimeCount {

    //Sieve of Eratothenes
    public static int countPrimes(int n) {
        if(n<2)
            return 0;

        //true: composites   false: prime
        boolean[] composites = new boolean[n];
        int limit = (int)Math.sqrt(n);

        for(int i=2; i<=limit; i++){
            if(!composites[i]){

                //mark all multiples of i -> true
                //The first index to be flipped to true i*i

                for(int j=i*i; j<n; j+=i)
                    composites[j]=true;
            }
        }

        int count = 0;
        for(int i=2; i<n; i++)
            if(!composites[i])
                count++;

        return count;
    }

    public static void main(String[] args) {
        int n=50;
        int primeCount = countPrimes(n);
        System.out.println("n="+50+", Primes count="+primeCount);
    }
}
