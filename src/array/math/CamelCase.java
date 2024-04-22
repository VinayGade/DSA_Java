package array.math;

import java.util.Scanner;

public class CamelCase {

    /*
    There is a sequence of words in CamelCase as a string of letters, , having the following properties:

    It is a concatenation of one or more words consisting of English letters.
    All letters in the first word are lowercase.
    For each of the subsequent words, the first letter is uppercase and rest of the letters are lowercase.

    s='toBeOrNotToBe'
    n=6
    * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] charaters=s.toCharArray();
        int count=1;
        for (int l=0;l<charaters.length;l++){
            if(charaters[l]>='A' && charaters[l]<='Z'){
                count++;
            }
        }
        System.out.print(count);
    }
}
