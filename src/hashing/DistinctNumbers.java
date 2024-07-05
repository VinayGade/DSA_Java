package hashing;

//CSES

/*
You are given a list of n integers,
and your task is to calculate the number of distinct values in the list.

Input:

5
2 3 2 2 3
Output:

2
* */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DistinctNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] a = new int[N];
        for(int i=0; i<N; i++)
            a[i] = scan.nextInt();
        int distinct = countDistinct(a, N);
        System.out.println(distinct);
    }

    /*
    static int countDistinct(int[] a, int n){
        Map<Integer, Integer> frequencyMap = frequency(a, n);
        return frequencyMap.entrySet().size();
    }
     */

    static int countDistinct(int[] a, int n){
        int count = 0;
        Map<Integer, Integer> frequencyMap = new HashMap< >();
        for(int i=0; i<n; i++){
            if(!frequencyMap.containsKey(a[i])) {
                frequencyMap.put(a[i], 1);
                count++;
            }else
                frequencyMap.put(a[i], frequencyMap.get(a[i]) + 1);
        }
        return count;
    }
}
