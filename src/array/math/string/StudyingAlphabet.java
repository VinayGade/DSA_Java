package array.math.string;

import java.util.Scanner;

//CodeChef: String
/*
Not everyone probably knows that Chef has younger brother Jeff. Currently Jeff learns to read.

He knows some subset of the letter of Latin alphabet.
In order to help Jeff to study, Chef gave him a book with the text consisting of N words.
Jeff can read a word if it consists only of the letters he knows.

Now Chef is curious about which words his brother will be able to read, and which are not.
Please help him!

Input:
act
2
cat
dog

Output:
Yes
No
* */

public class StudyingAlphabet {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            String w = scanner.next();
            String result = canRead(s, w) ? "Yes" : "No";
            System.out.println(result);
        }
    }

    static boolean canRead(String s, String w) {
        boolean contains = true;
        for (int i = 0; i < w.length(); i++) {
            if (!s.contains(String.valueOf(w.charAt(i)))) {
                contains = false;
                break;
            }
        }
        return contains;
    }
}
