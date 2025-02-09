package array.math;

public class DigitCountFactorial {

    static long factorial(int n){
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    static int digitsInFactorial(int N){
        // finding factorial of a number
        long fact = factorial(N);

        // counting the number of digits present
        // in the factorial of number N
        int d = 0;
        while (fact != 0) {
            fact /= 10;
            d += 1;
        }
        return d;
    }

    //Recursion + String
    public int digitsOfFactorial(int N){
        long fact = factorialRecursive(N);
        String factorialString = String.valueOf(fact);
        return factorialString.length();
    }

    public long factorialRecursive(int n){
        if(n==0)
            return 1;
        else
            return n * factorialRecursive(n-1);
    }

    //optimised

    //Math : Log
    public static int countDigitsFactorial(int N){
        double sum = 0.0d;
        for(int j=1; j<=N; j++){
            sum += Math.log10(j);
        }
        return (int) (1+Math.floor(sum));
    }

    public static void main(String[] args) {
        int n= 5;
        int count = countDigitsFactorial(n);
        System.out.println("Digit count = " +count);

        int num = 45;
        int countDigits = digitsInFactorial(num);
        System.out.println("Digit count = " +countDigits);
    }
}
