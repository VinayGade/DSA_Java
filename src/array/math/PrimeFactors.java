package array.math;

import java.util.ArrayList;

public class PrimeFactors {

    public static ArrayList < Integer > factor(int n) {
        ArrayList< Integer > ret = new ArrayList < > ();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                ret.add(i);
                n /= i;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int number = 150;    // 300  1000 250
        ArrayList < Integer > primeFactors = factor(number);
        primeFactors.forEach(x->System.out.print(x+" "));
    }
}
