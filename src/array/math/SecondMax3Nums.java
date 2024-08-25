package array.math;

import java.util.Scanner;

/*
CodeChef: basic-math: Second Max of Three Numbers

input:

3
1 2 3
10 15 5
100 999 500

Output:

2
10
500
* */
public class SecondMax3Nums {

    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        while (N-- > 0) {

            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            int second = 0;
            if ((a > b || a > c) && (a < b || a < c))
                second = a;
            else if ((b > a || b > c) && (b < a || b < c))
                second = b;
            else
                second = c;
            System.out.println(second);
        }
    }
}
