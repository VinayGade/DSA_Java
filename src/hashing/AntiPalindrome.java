package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AntiPalindrome {

    public static void main(String[] args) throws Exception
    {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int n = scanner.nextInt();
            String s = scanner.next();

            int count = makeAntiPalindrome(s, n);

            System.out.println(count);
        }
    }

    static int makeAntiPalindrome(String s, int n){
        char[] str = s.toCharArray();
        int count = 0;
        if (n > 2) {

            /*
             Algorithm:

             Step 1: Find Frequency of each character in String and store it in a Map.
                      for each entry in map,  e.key: character, e.value: frequency (int)

                     Map map = charFrequency(s, n);

                     Map charFrequency(s, n){
                        for each character c in s {
                            if(map contains c){
                                map. put( c, map.get(c) + 1)
                            else  map. put( c, 1)
                        }
                        return map;
                     }

            Step 2: initialize 3 variables.

                   oddCount = 0  ... total number of that have odd frequency
                   evenCount = 0 ... total number of that have even frequency
                   count = 0 ... total number of operations to make palindrome -> anti-palindrome

                   (Note: From frequency-map we computed in step 1, we can find oddCount, evenCount.)

            Step 3: Find values of  oddCount and evenCount (based on frequency-map in step 1).

                    for each entry e in map {
                        if e.v is EVEN
                            evenCount++
                        else  oddCount++
                    }

            Step 4: Find value of count.
                    (total number of operations to make palindrome -> anti-palindrome.)

                    i.  if n is EVEN
                           count++    ... if oddCount LESS THAN = 0
                                       (1 or more ch in S is repeating)

                    ii. else{
                            if (oddCount LESS THAN = 1){
                                 if(oddCount == 1) {
                                    if(evenCount == 0)
                                        count+=2
                                    else
                                        count++
                                 }
                        }

            Step 5: Return count
             */


            Map< Character, Integer > frequencyMap = charFrequency(str, n);

            Set< Map.Entry < Character, Integer >> entrySet = frequencyMap.entrySet();


                /*
                if (n%2 == 0){
                if (odd>0){
                    System.out.println(0);
                }else{
                    System.out.println(1);
                }
                }else{
                if (odd>1){
                    System.out.println(0);
                } else if (odd == 1) {
                    if (even == 0){
                        System.out.println(2);
                    }else{
                        System.out.println(1);
                    }
                }
                }
                */

            int size = entrySet.size();
            /*
            if (size == 1) {
                if (n % 2 == 0)
                    count++;
                else
                    count += 2;

            }
            else {
             */
                int oddFreqCount = 0;
                int evenFreqCount = 0;
                for (Map.Entry < Character, Integer > entry: entrySet) {
                    if (entry.getValue() % 2 == 0)
                        evenFreqCount++;
                    else
                        oddFreqCount++;
                }

                if (n % 2 == 0) {
                        /*
                        if (oddFreqCount > 0) {
                            count = 0;
                        } */
                    if (oddFreqCount <= 0)
                        count++;
                } else {
                    if (oddFreqCount <= 1) {
                            /*count = 0;
                        } else*/
                        if (oddFreqCount == 1) {
                            if (evenFreqCount == 0) {
                                count += 2;
                            } else {
                                count++;
                            }
                        }
                    }
                }

                    /*
                    for(Map.Entry<Character, Integer> entry:
                       entrySet){
                        if(n%2==0){
                        if(entry.getValue()%2!=0)
                            oddFreqCount++;
                            count++;
                            break;
                        }else{
                            if(entry.getValue()%2!=0)
                                oddFreqCount++;
                        }
                    }
                    count = ((oddFreqCount == n) || (oddFreqCount%2==0) || oddFreqCount != 0) ? 0 :++count;
                    */
            //}
        } else {
            if (str[0] == str[1])
                count++;
        }
        return count;
    }

    static Map < Character, Integer > charFrequency(char[] s, int size) {

        Map < Character, Integer > frequencyMap = new HashMap< >();
        for (int i = 0; i < size; i++) {
            //for (char ch : s.toCharArray())
            frequencyMap.put(s[i], frequencyMap.getOrDefault(s[i], 0) + 1);
        }
        return frequencyMap;
    }
}
