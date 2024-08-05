package array.math;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class PrimeDistinct {

    /*
input:
2
121
26

output:
1
2
    * */
    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int N = scanner.nextInt();
            int count = countFactors(N);

            System.out.println(count);

        }
    }

    static int countFactors(int number){
        Set<Integer> primeFactors = primeFacots(number);
        return primeFactors.size();
    }

    static Set<Integer> primeFacots(int n){
        Set<Integer> ret = new LinkedHashSet< >();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                ret.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            ret.add(n);
        }
        return ret;
    }
}
