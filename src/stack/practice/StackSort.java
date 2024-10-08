package stack.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StackSort {

    /*
2
4
1 2 4 3
4
1 3 4 2

YES
NO
    * */

    static boolean stackSort(int[] a, int N) {

        List< Integer > b = new ArrayList< >();
        Stack< Integer > stack = new Stack < > ();

        for (int i = 0; i < N; i++) {

            stack.push(a[i]);

// Pop from stack to B while stack is not empty and top of stack // is less than the next element in A
            while (!stack.isEmpty() && (i == N - 1 || stack.peek() < a[i + 1])) {
                b.add(stack.pop());
            }
        }

        // Pop remaining elements in stack to B
        while (!stack.isEmpty()) {
            b.add(stack.pop());
        }

        // Check if list B is sorted
        for (int i = 0; i < b.size() - 1; i++) {
            if (b.get(i) > b.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    static boolean stackSort_Optimized(int[] A, int N) {

        Stack<Integer> S = new Stack<>();
        int expected = 1;
        for (int num : A) {
            while (!S.empty() && S.peek() == expected) {
                S.pop();
                expected++;
            }
            if (num == expected)
                expected++;
            else {
                if (!S.empty() && S.peek() < num)
                    return false;
                S.push(num);
            }
        }
        return true;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int N = scanner.nextInt();
            int[] a = new int[N];

            for (int i = 0; i < N; i++)
                a[i] = scanner.nextInt();

            String sorted = stackSort(a, N) ? "YES" : "NO";
            System.out.println(sorted);
        }
    }

}
