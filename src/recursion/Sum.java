package recursion;

public class Sum {

    public int recursiveSum(int n){
        if(n==1)
            return n;
        else
            return n + recursiveSum(n-1);
    }

    private int iterativeSum(int n){
        int total = 0;
        for(int i = 1; i <= n; i++){
            total += i;
        }
        return total;
    }

    private int recursiveSumArray(int [] a, int n){
        if(n<=0)
            return 0;
        else
            return recursiveSumArray(a, n-1) + a[n-1];
    }

    private int iterativeSumArray(int [] a){
        int total = 0;
        int n = a.length;
        for(int i = 0; i < n; i++){
            total += a[i];
        }
        return total;
    }

    public static void main(String[] args) {

        int n = 25;
        int [] a = {10, 20, 30, 40, 50, 60, 70, 80, 90};

        Sum s = new Sum();

        int sum = s.recursiveSum(n);

        int sumArray = s.recursiveSumArray(a, a.length);

        int sumRecursive = s.recursiveSum(n);

        int sumArrayRec = s.iterativeSumArray(a);

        System.out.println("sum from 1 to n ="+sum);

        System.out.println("sum from 1 to n iterative ="+sumRecursive);

        System.out.println("sum a[] ="+sumArray);

        System.out.println("sum a[] recursive ="+sumArrayRec);
    }
}
