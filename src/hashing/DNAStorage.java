package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// CodeChef: DNA Storage

/*
For encoding an even-length binary string into a sequence of A, T, C, and G,
we iterate from left to right and replace the characters as follows:

00 is replaced with A
01 is replaced with T
10 is replaced with C
11 is replaced with G

Input:
4
2
00
4
0011
6
101010
4
1001

Output:
A
AG
CCC
CT
* */

public class DNAStorage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();

            String DNA = encodeDNA(s, n);
            System.out.println(DNA);
        }
    }

    static String encodeDNA(String binary, int N){

        Map<String, String> dnaMap = new HashMap<>();
        dnaMap.put("00", "A");
        dnaMap.put("01", "T");
        dnaMap.put("10", "C");
        dnaMap.put("11", "G");

        //char[] binaray = input.toCharArray();

        StringBuilder encoded = new StringBuilder();

        for(int i=0; i<N; i+=2){
            String key = binary.substring(i, i+2);
            //encoded += dnaMap.get(key);
            encoded.append(dnaMap.get(key));
        }
        return encoded.toString();
    }
}
