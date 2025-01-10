package array.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Divisible by 60:

Given a large number represent in the form of an integer array A,
where each element is a digit.

You have to find whether there exists any permutation of the array A
such that the number becomes divisible by 60.

Return 1 if it exists, 0 otherwise.

Input 1:
A = [0, 6]

Input 2:
A = [2, 3]

Output 1:
1
Output 2:
0
* */
public class DivisibleBy60 {

    static int divisibleBy60(List<Integer> A) {
        int n = A.size();
        if(!A.contains(0))
            return 0;
        if(n == 1 && A.get(0) == 0){
            return 1;
        }
        int sum = 0;
        boolean even = false;
        for(int x: A){
            if(x!=0 && x%2 == 0)
                even = true;
            sum += x;
        }
        return (even && (sum % 3 == 0)) ? 1 : 0;
    }

    public static void main(String[] args) {
        int[] A = {0, 6};  // int[] A = {2, 3};
        List<Integer> a = new ArrayList<>();

        for(int x: A){
            a.add(x);
        }

        int divisible60 = divisibleBy60(a);

        System.out.println(divisible60);

    }
}
