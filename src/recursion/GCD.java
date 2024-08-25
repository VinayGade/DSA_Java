package recursion;

public class GCD {

    public static void main(String[] args) {
        int a=12;
        int b=4;
        System.out.println("gcd("+a+", "+b+")="+gcd(a,b));
        System.out.println("hcf("+a+", "+b+")="+HCF(a,b));
        System.out.println("lcm("+a+", "+b+")="+lcm(a,b));
    }

    // CodeChef: GCD == HCF  ...iterative approach

    // Euclid Algorithm

    /*
    Euclid's Algorithm is a widely used method for finding the Greatest Common Divisor (GCD)
    of two positive integers.

    gcd(a, b) = gcd(b, a % b)

    gcd(a, b) = a             ... b = 0
              = gcd(b, a % b) ... otherwise
    * */
    static int HCF(int a, int b) {
        int r;
        while (b > 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    //Euclid's repeated division approach
    public static int gcd(int a, int b){

        //old
        /*
        if(a%b == 0)
            return b;
        else return gcd(b, a-b);
         */

        // if b=0, a is the GCD
        if (b == 0)
            return a;

            // call the gcd() method recursively by
            // replacing a with b and b with
            // modulus(a,b) as long as b != 0
        else
            return gcd(b, a % b);
    }

    public static int lcm(int a, int b){
        int product = a*b;
        int gcd = gcd(a, b);
        return product/gcd;
    }

    // Schaum's outline
    public static int GCD(int m, int n) {
        if (m == n)
            return n;
        else if (m < n)
            return gcd(m, n - m);
        else
            return gcd(m - n, n);
    }

    static long LCM(long a, long b, long gcd) {

        //long product = a * b;

        // GCD(a, b) * LCM(a, b) = a * b

        // return (gcd == 1) ? product : (long) Math.round(product / gcd);

        return (a * b / gcd);
    }
}