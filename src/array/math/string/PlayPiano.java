package array.math.string;

import java.util.Scanner;

//CodeChef: strings: Play Piano
/*
Two sisters, A and B, play the piano every day. During the day, they can play in any order.
That is, A might play first and then B, or it could be B first and then A.
But each one of them plays the piano exactly once per day.
They maintain a common log, in which they write their name whenever they play.

You are given the entries of the log, but you're not sure if it has been tampered with or not.
Your task is to figure out whether these entries could be valid or not.

Input :
4
AB
ABBA
ABAABB
AA

Output:
yes
yes
no
no

Explanation:
Testcase 1:
There is only one day, and both A and B have played exactly once.
So this is a valid log. Hence 'yes'.

Testcase 2:
 On the first day, A has played before B, and on the second day, B has played first.
 Hence, this is also a valid log.

Testcase 3:
On the first day, A played before B, but on the second day, A seems to have played twice.
This cannot happen, and hence this is 'no'.
* */

public class PlayPiano {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            String s = scanner.next();
            String validity = isValid(s) ? "yes" : "no";
            System.out.println(validity);
        }
    }

    static boolean isValid(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int i = 0;
        int j = 1;
        while (i < (n-1) && j < n) {
            if(s[i] == s[j]){
                return false;
            }
            i+=2;
            j+=2;
        }
        return true;
    }
}
