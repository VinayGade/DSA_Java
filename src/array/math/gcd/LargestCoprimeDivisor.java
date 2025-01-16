package array.math.gcd;

/*
You are given two positive numbers A and B. You need to find the maximum valued
integer X such that:

X divides A i.e. A % X = 0
X and B are co-prime i.e. gcd(X, B) = 1

A = 30
B = 12
We return
X = 5
* */

public class LargestCoprimeDivisor {

    public static int cpFact(int A, int B) {
        if(gcd(A, B) == 1)
            return A;
        return cpFact(A/ gcd(A, B), B);
    }

    static int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        int A = 30;
        int B = 12;
        int result = cpFact(A, B);
        System.out.println(result);
    }
}
