package array.math.two_pointers;

import java.util.ArrayList;

public class PrimePairWithSum {

    public static ArrayList<Integer> getPrimes(int n) {

        ArrayList<Integer> primePair = new ArrayList<>();
        int i = 2;
        int j = n-i;
        while( i <= j && i < n ){
            if(prime(j)){
                if(prime(i)){
                    primePair.add(i);
                    primePair.add(j);
                    break;
                }
            }
            i++;
            j--;
        }
        if(primePair.isEmpty()){
            primePair.add(-1);
            primePair.add(-1);
        }
        return primePair;
    }

    public static boolean prime(int N){

        boolean isPrime = true;

        for (int y = 2; y * y <= N; y++) {
            if (N % y == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        int n=4;   // 3+7=10
        //72 = 5 + 67
        //4 = 2+2
        ArrayList<Integer> primes = getPrimes(n);
        primes.forEach(System.out::println);
    }
}
