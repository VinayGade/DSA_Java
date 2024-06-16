package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
CodeChef: Your Name is Mine

In an attempt to control the rise in population, Archer was asked to come up with a plan.
This time he is targeting marriages.
Archer, being as intelligent as he is, came up with the following plan:

Man  : M
Woman: W

M = subStr (W) || W = subStr (M)

A is said to be a subsequence of B, if A can be obtained by deleting some elements of B
without changing the order of the remaining elements.

Find if couple is allowed to marry according to Archer's rule.

* */
/*
Input:
3
john johanna
ira ira
kayla jayla

Output:
YES
YES
NO
* */

public class YourNameMine {

    static boolean isValid(String M, String W){
        int m = M.length();
        int w = W.length();

        int min = -1;
        int max = -1;

        String minStr, maxStr;

        if(m > w){
            min = w;
            max = m;
            maxStr = M;
            minStr = W;
        }else{
            max = w;
            min = m;
            maxStr = W;
            minStr = M;
        }
         /*
        int min = Math.min(m, w);
        int max = Math.max(m, w);
        */

        char[] min_arr =  minStr.toCharArray();
        char[] max_arr =  maxStr.toCharArray();

        int k = 0;
        //boolean flag = false;

        for(int i=0; i<max; i++){
            if(min_arr[k] == max_arr[i])
                k++;
            if(k == min){
                return true;
            }
        }
        return false;
    }

    static boolean validity(String M, String W){
        int m = M.length();
        int w = W.length();
        Map<Character, Integer> mFrequency = findFrequency(M);
        Map<Character, Integer> wFrequency = findFrequency(W);
        if(w > m){
            Map<Character, Integer> temp = mFrequency;
            mFrequency = wFrequency;
            wFrequency = temp;
        }
        for(Map.Entry<Character, Integer> we: wFrequency.entrySet()){

            char c = we.getKey();
            if(!mFrequency.containsKey(c))
                return false;
	        /*
	        int v = we.getValue();
	        if(v > mFrequency.get(we.getKey()))
	            return false;
	        */
        }
        return true;
    }

    static Map<Character, Integer> findFrequency(String S){
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }
        return charFrequencyMap;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0) {
            String M = scan.next();
            String W = scan.next();
            /*
            String result = W.contains(M) || M.contains(W) ? "YES":
                    validity(M, W) ? "YES" : "NO";

             */
            String result = isValid(M, W) ? "YES" : "NO";
            System.out.println(result);
        }
    }
}
