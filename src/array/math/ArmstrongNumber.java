package array.math;

public class ArmstrongNumber {

    static String armstrongNumber(int n) {
        int sum = 0;

        int x = n;

        int rem;

        while (x > 0) {
            rem = x % 10;
            sum += (rem * rem * rem);
            x = x / 10;
        }

        return (sum == n) ? "true": "false";
    }

    static String armstrongNumber2(int n) {

        int sum = 0;
        String N = String.valueOf(n);

        for(int i=0; i<N.length(); i++){
            int digit = (int)(N.charAt(i));
            sum += (digit * digit * digit);
        }

        return (sum == n) ? "true": "false";
    }

    static int digitsSum(int n)
    {
        int sum = 0;
        // remainder
        int rem;

        while (n > 0) {
            rem = n % 10;
            sum += rem;
            n = n / 10;
        }

        return sum;
    }
    public static void main(String[] args) {

        int n=153;  // n=372

        System.out.println("sum of digits ="+digitsSum(n));

        System.out.println(armstrongNumber(n));

    }
}
