package array.math.two_pointers;

import java.util.ArrayDeque;
import java.util.Scanner;

public class VowelAnxiety {

    static String vowelAnxiety(String s, int n){
        ArrayDeque<Character> l = new ArrayDeque < > ();
        char f, t = 0;

        for (int i = 0; i < n; i++) {
            f = s.charAt(i);
            String vowels = "aeiou";
            //if (f == 'a' || f == 'e' || f == 'i' || f == 'o' || f == 'u') {
            if(vowels.contains(String.valueOf(f)))
                t++;
            if (t % 2 == 0) {
                l.addLast(f);
            } else {
                l.addFirst(f);
            }
        }

        StringBuilder w = new StringBuilder();
        if (t % 2 == 0) {

            while (!l.isEmpty()) {
                w.append(l.pollFirst());
            }

        } else {
            while (!l.isEmpty()) {
                w.append(l.pollLast());
            }
        }
        return w.toString();
    }
    public static void main(String[] args) throws Exception {
        Scanner x = new Scanner(System.in);

        int T = x.nextInt();
        while (T-- > 0) {

            int n = x.nextInt();
            String s = x.next();
            String w = vowelAnxiety(s, n);

            System.out.println(w);
        }
    }
}
