package array.math;

import java.util.ArrayList;
import java.util.Collections;

//Given a number A, find all factors of A.
/*
Example Input
A = 6

Example Output
[1, 2, 3, 6]

Example Explanation
For the given A = 6, its factors are 1, 2, 3, and 6, hence returning an array of them.
* */
public class Factorization {

    static ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> factors = new ArrayList<>();
        for(int i = 1 ; i <= Math.sqrt(A) ; i++){
            if(A % i == 0 ){
                factors.add(i);
                if(i != A / i){
                    factors.add(A/i);
                }
            }
        }
        Collections.sort(factors);
        return factors ;
    }

    public static void main(String[] args) {
        int A = 6;
        ArrayList<Integer> factors = allFactors(A);
        factors.forEach(factor -> System.out.print(factor+" "));
    }
}
