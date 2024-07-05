package array.math;

public class CompareFractions {

    static String compareFrac(String str) {

        // Extract fractions from the input string
        String f1 = str.substring(0, str.indexOf(','));
        String f2 = str.substring(str.indexOf(',') + 2);

        // Parse the first fraction
        int a = Integer.parseInt(f1.substring(0, f1.indexOf('/')));
        int b = Integer.parseInt(f1.substring(f1.indexOf('/') + 1));

        // Parse the second fraction
        int c = Integer.parseInt(f2.substring(0, f2.indexOf('/')));
        int d = Integer.parseInt(f2.substring(f2.indexOf('/') + 1));

        // Cross-multiplication to compare fractions
        int A1 = a * d;
        int A2 = c * b;

        // Compare and return the result
        if (A1 == A2)
            return "equal";
        else if (A1 > A2) {
            return f1;
        }
        return f2;
    }

    public static void main(String[] args) {
        String str = "5/6, 11/45";
        String result = compareFrac(str);
        System.out.println(result);
    }
}
