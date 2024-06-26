package hashing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//CodeChef : Difficulty:  1012

/*
Chef is fan of pairs and he likes all things that come in pairs.
He even has a doll collection in which the dolls come in pairs.
One day while going through his collection he found that there are odd number of dolls.
Someone had stolen a doll!!!

Help chef find which type of doll is missing..

Input
The first line contains an integer T, the number of test cases.
The first line of each test case contains an integer N, the number of dolls.
The next N lines are the types of dolls that are left.

Output
For each test case, display the type of doll that doesn't have a pair, in a new line.

Constraints
1<=T<=10
1<=N<=100000 (10^5)
0<=type<=100000

input:
1
3
1
2
1

Output:
2

Input:
1
5
1
1
2
2
3

Output:
3
* */
public class ChefDolls {

    static Map<Integer, Integer> dollFrequency(int[] dolls){
        Map<Integer, Integer> dollFrequencyMap = new LinkedHashMap<>();
        for(int doll: dolls)
            dollFrequencyMap.put(doll,
                    dollFrequencyMap.getOrDefault(doll, 0) + 1);

        return dollFrequencyMap;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0){
            int N = scan.nextInt();
            int[] dolls = new int[N];
            for(int i=0; i<N; i++)
                dolls[i] = scan.nextInt();
            int missing = 0;
            Map<Integer, Integer> dollFrequencies = dollFrequency(dolls);
            for(Map.Entry<Integer, Integer> entry: dollFrequencies.entrySet()){
                if(entry.getValue()%2 != 0) {// odd number of dolls
                    missing = entry.getKey();
                    break;
                }
            }
            System.out.println(missing);
        }
    }
}
