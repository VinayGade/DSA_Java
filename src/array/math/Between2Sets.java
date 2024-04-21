package array.math;

import java.util.Arrays;
import java.util.List;

//HackerRank
/*
There will be two arrays of integers. Determine all integers that satisfy following 2 conditions:

The elements of the first array are all factors of the integer being considered
The integer being considered is a factor of all elements of the second array
These numbers are referred to as being between the two arrays.
Determine how many such numbers exist.

a=[2, 4]
b=[16, 32, 96]

y=LCM(a) == 4
x=GCD(b) == 16

multiples(y)      = [4, 8, 12, 16]
common factors(x) = [4, 8,     16]

count=3
* */
public class Between2Sets {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int count = 0;

        //(1) Get LCM of all elements of a
        int lcm = a.get(0);
        for(Integer i: a)
            lcm = getLCM(lcm, i);

        //(2) Get GCD of all elements of b
        int gcd = b.get(0);
        for(Integer i: b)
            gcd = getGCD(gcd, i);

        //(3) Count multiples of lcm that divide the gcd
        int multiple = 0;
        while(multiple <= gcd){
            multiple += lcm;
            if(gcd % multiple==0)
                count++;
        }
        return count;
    }

    static int getGCD(int n1, int n2) {
        if (n2 == 0)
            return n1;

        return getGCD(n2, n1 % n2);
    }

    static int getLCM(int n1, int n2) {
        if (n1 == 0 || n2 == 0)
            return 0;
        else {
            int gcd = getGCD(n1, n2);
            return Math.abs(n1 * n2) / gcd;
        }
    }
    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(2,6);
        List<Integer> b = Arrays.asList(24,36);
        System.out.println("count = "+getTotalX(a,b));
    }
}
