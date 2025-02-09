package array.math;

import java.util.ArrayList;
import java.util.Scanner;

/*
Quadratic Equation Roots:

Given a quadratic equation ax^2 + bx + c = 0, find its roots.
If the roots are imaginary, return only one integer -1.
Always return the roots as the greatest integers less than or equal to the actual roots,
with the maximum root first followed by the minimum root.

input:
2
1 -7 12
1 -2 1

Output:
4 3
1 1

Explanation:
a=1 b=-7 c=12
=>    y = x^2 -7x + 12
        = (x-4) (x-3)

a=1 b=-2 c=1
=>    y = x^2 -2x + 1
        = (x-1) (x-1)
* */
public class QuadraticRoots {

    public ArrayList<Integer> quadraticRoots(int a, int b, int c) {

        ArrayList<Integer> roots = new ArrayList<>();
        int root1 = 0;
        int root2 = 0;

        // b^2 - 4*a*c
        int temp = (int)(Math.pow(b, 2) - 4 * a *c);

        if(temp < 0)
            roots.add(-1);

        else{
            root1 = (int) (Math.floor((-1 * b + Math.sqrt(temp)) / (2*a)));
            root2 = (int) (Math.floor((-1 * b - Math.sqrt(temp)) / (2*a)));
            roots.add(Math.max(root1, root2));
            roots.add(Math.min(root1, root2));
        }
        return roots;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int a, b, c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            QuadraticRoots obj = new QuadraticRoots();
            ArrayList<Integer> ans = obj.quadraticRoots(a, b, c);
            if (ans.size() == 1 && ans.get(0) == -1)
                System.out.print("Imaginary");
            else
                for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
