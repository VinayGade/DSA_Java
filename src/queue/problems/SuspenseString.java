package queue.problems;

/*
CodeChef: Suspense String

Alice and Bob are playing a game with a binary string S. ... |S| = N
also empty string T.

They both take turns and Alice plays first.

In Alice's turn, she picks the first character of string S and append it to front/ end of T.
Delete chosen first char from S.

In Bob's turn, he picks the last character of string S, append it to front/ end of T.
Delete chosen first char from S.

if(S isEmpty) -> stop game.

Alice wants T -> Lexicographically smallest
Bob wants T -> Lexicographically largest

Find the resultant string T.

Input:

4
2
10
4
0001
6
010111
10
1110000010

Output:

10
0100
101101
0011011000

 eg2.

 S = 0001

      S            T
A     001          0
B     00           01
A     0            010
B     -            0100

T = 0100

eg 3

S = 010111

       S            T
A      10111        0
B      1011         10
A      011          101
B      01           1101
A      1            01101
B      -            101101

eg 4

S = 1110000010

       S                T

A      110000010        1
B      11000001         10
A      1000001          101
B      100000           1101
A      00000            11011
B      0000             011011
A      000              0011011
B      00               00110110
A      0                001101100
B      -                0011011000

* */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SuspenseString {

    static String conversion(String s, int N){
        Deque<Character> deque = new ArrayDeque<>();

        int left = 0;
        int right = N-1;

        for (int i = 0; i < N; i++){
            if(i%2==0){       // Even index = Alice
                if(s.charAt(left) == '0')
                    deque.addFirst(s.charAt(left));
                else
                    deque.addLast(s.charAt(left));
                left++;
            }else{           // odd index = Bob
                if(s.charAt(right) == '1')
                    deque.addFirst(s.charAt(right));
                else
                    deque.addLast(s.charAt(right));
                right--;
            }
        }

        StringBuilder result = new StringBuilder();
        for(char ch: deque)
            result.append(ch);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int N = scanner.nextInt();
            String S = scanner.next();
            String result = conversion(S, N);

            System.out.println(result);
        }
    }
}
