package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateValidParenthesis("", n, 0, 0, result);
        return result;
    }

    static void generateValidParenthesis(String s, int n, int o, int c, List<String> allValidParenthesis){

        if(s.length() == n*2){
            allValidParenthesis.add(s);
            return;
        }
        if(o < n){
            //a[i]='(';
            generateValidParenthesis(s+"(", n, o+1, c, allValidParenthesis);
        }
        if(c < o){
            //a[i]=')';
            generateValidParenthesis(s+")", n, o, c+1, allValidParenthesis);
        }
    }

    static void parenthesisBackTracking(char[] a, int n, int i, int o, int c) {
        if (i == a.length) {
            System.out.println(a);
            //System.out.println("\nnumber of combinations = "+a.length);
        }
        if (o < n) {
            a[i] = '(';
            parenthesisBackTracking(a, n, i + 1, o + 1, c);
        }
        if (c < o) {
            a[i] = ')';
            parenthesisBackTracking(a, n, i + 1, o, c + 1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<String> result = generateParenthesis(n);

        System.out.println("\nn ="+n);
        System.out.println("Display all combinations of valid parentheses.");
        result.forEach(System.out::println);

        System.out.println("\nnumber of combinations = "+result.size());

        n=3;
        System.out.println("\nn ="+n);
        System.out.println("Display all combinations of valid parentheses.");
        char[] a=new char[n*2];
        parenthesisBackTracking(a, n, 0, 0, 0);
    }
}
