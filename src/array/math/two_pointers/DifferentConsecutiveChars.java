package array.math.two_pointers;

import java.util.Scanner;

public class DifferentConsecutiveChars {

    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int N = scanner.nextInt();
            String s = scanner.next();

            int count = countOperations(s, N);
            System.out.println(count);
        }
    }

    static int countOperations(String s, int n){
        char[] c = s.toCharArray();
        int count = 0;
        int i = 0;
        int j = i+1;
        while(j < n){
            if(c[i] == c[j]){
                count++;
            }
            i++;
            j++;
        }
        return count;
    }
}
