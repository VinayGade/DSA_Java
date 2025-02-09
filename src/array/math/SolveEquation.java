package array.math;

/*
LeetCode 640. Solve the Equation:

Solve a given equation and return the value of 'x' in the form of a string "x=#value".
The equation contains only '+', '-' operation, the variable 'x' and its coefficient.
You should return "No solution" if there is no solution for the equation, or
"Infinite solutions" if there are infinite solutions for the equation.

If there is exactly one solution for the equation, we ensure that the value of 'x' is an integer.

Example 1:

Input: equation = "x+5-3+x=6+x-2"
Output: "x=2"

Example 2:

Input: equation = "x=x"
Output: "Infinite solutions"

Example 3:

Input: equation = "2x=x"
Output: "x=0"
* */

public class SolveEquation {

    public static String solveEquation(String equation) {
        int[] res = evaluateExpression(equation.split("=")[0]),
                res2 = evaluateExpression(equation.split("=")[1]);
        res[0] -= res2[0];
        res[1] = res2[1] - res[1];
        if (res[0] == 0 && res[1] == 0)
            return "Infinite solutions";
        if (res[0] == 0)
            return "No solution";
        return "x=" + res[1]/res[0];
    }

    public static int[] evaluateExpression(String exp) {
        String[] tokens = exp.split("(?=[-+])");
        int[] res =  new int[2];
        for (String token : tokens) {
            if (token.equals("+x") || token.equals("x"))
                res[0] += 1;
            else if (token.equals("-x"))
                res[0] -= 1;
            else if (token.contains("x"))
                res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
            else
                res[1] += Integer.parseInt(token);
        }
        return res;
    }

    public static void main(String[] args) {
        String equation = "x+5-3+x=6+x-2";
        String result = solveEquation(equation);
        System.out.println(result);
    }
}
