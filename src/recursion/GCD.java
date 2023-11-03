package recursion;

public class GCD {

    public static void main(String[] args) {
        int a=12;
        int b=4;
        System.out.println("gcd("+a+", "+b+")="+gcd(a,b));
        System.out.println("lcm("+a+", "+b+")="+lcm(a,b));
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
}
