package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lapindromes {

/*
Lapindromes

Lapindrome is defined as a string which when split in the middle,
gives two halves having the same characters and same frequency of each character.
If there are odd number of characters in the string, we ignore the middle character
and check for lapindrome. For example gaga is a lapindrome,
since the two halves ga and ga have the same characters with same frequency.
Also, abccab, rotor and xyzxy are a few examples of lapindromes.
Note that abbaab is NOT a lapindrome.
The two halves contain the same characters but their frequencies do not match.
Your task is simple. Given a string, you need to tell if it is a lapindrome.

Input:
First line of input contains a single integer T, the number of test cases.
Each test is a single line containing a string S composed of only lowercase English alphabet.

Output:
For each test case, output on a separate line:
"YES" if the string is a lapindrome and "NO" if it is not.
* */

    /*
i/p:
7
glyplgpy
gaga
abcde
rotor
xyzxy
abbaab
ababc


o/p:
YES
YES
NO
YES
YES
NO
NO

    * */

    static boolean isLapindrome(String S){

        int n = S.length();
        int half = n/2;
        //boolean odd = n%2 != 0;

        //char c='\u0000';   // initialization required, otherwise CF

        /*
        if(half % 2 != 0){
            n--;
            //c = S.charAt(half);
        }
         */

        if(n<=3)
            return S.charAt(0) == S.charAt(n-1);

        System.out.println(S);
        if(n%2 != 0) {
            StringBuilder sb = new StringBuilder(S);
            sb.deleteCharAt(half);
            //S = S.replace(String.valueOf(c),"");

            S = sb.toString();
        }
        String s1 = S.substring(0, half);
        //String s2 = S.substring(half, n);

        //String s2 = !odd ? S.substring(half) : S.substring(half+1);
        //String s2 = !odd ? S.substring(half-1) : S.substring(half);
        String s2 = S.substring(half);

        //subString2 = ( n%2 == 0 ) ? input.substring( n/2 ) : input.substring( n/2 + 1 );

        System.out.println(S+" "+s1+" "+s2);

        Map<Character, Integer> s1Map = charFrequency(s1, half);
        Map<Character, Integer> s2Map = charFrequency(s2, half);

        boolean flag=true;

        for(Map.Entry<Character, Integer> entry: s1Map.entrySet()){
            int v = entry.getValue();
            char k = entry.getKey();
            if(!s2Map.containsKey(k) || s2Map.get(k)!=v) {
                flag=false;
                break;
            }
        }
        //return s1Map.equals(s2Map);
        return flag;
    }

    static Map<Character, Integer> charFrequency(String s, int half){

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(int i=0; i<half; i++) {
            //for (char ch : s.toCharArray())
            char ch = s.charAt(i);
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main (String[] args) throws java.lang.Exception{

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0){
            String S = scan.next();
            String result = isLapindrome(S) ? "YES" : "NO";
            System.out.println(result);
        }
    }
}
