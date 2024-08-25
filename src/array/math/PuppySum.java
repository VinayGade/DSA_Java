package array.math;

import java.util.Scanner;

public class PuppySum {

    /*
    Yesterday, puppy Tuzik learned a magically efficient method to find the sum of the integers from 1 to N. He denotes it as sum(N).
    But today, as a true explorer, he defined his own new function:
    sum(D, N), which means the operation sum applied D times:
    the first time to N, and each subsequent time to the result of the previous operation.

    For example, if D = 2 and N = 3, then sum(2, 3) equals to sum(sum(3)) = sum(1 + 2 + 3)
                                                                           = sum(6) = 21

    Tuzik wants to calculate some values of the sum(D, N) function.

Input
2
1 4
2 3

output:
10
21

Explain:

sum (1..N) = N * (N + 1) / 2;

1st input:
Here, D = 1 and N = 4.
We need to calculate sum(1, 4), which is just the sum of integers from 1 to 4.
The sum is calculated as 1 + 2 + 3 + 4 = 10.

2nd input:
Here, D = 2 and N = 3.
First, we calculate sum(3), which is the sum of integers from 1 to 3.
sum(3) = 1 + 2 + 3 = 6.
Now, apply sum again on the result: sum(6), which is the sum of integers from 1 to 6.
sum(6) = 1 + 2 + 3 + 4 + 5 + 6 = 21.

    * */
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int D = scanner.nextInt();
            int N = scanner.nextInt();

            for (int i = 0; i < D; i++)
                N = puppySum(N);

            System.out.println(N);
        }
    }

    static int puppySum(int N) {
        int sum = N * (N + 1) / 2;
        return sum;
    }
}
