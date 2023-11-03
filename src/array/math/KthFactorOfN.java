package array.math;

// Leetcode 1492. The kth Factor of n (Amazon)
public class KthFactorOfN {

    public static int kthFactor(int n, int k) {
        int count = 1;
        //ArrayList<Integer> factors = new ArrayList<>();
        for (int i=1; i<=n; i++){
            if (n%i==0){
                //factors.add(i);
                if(count == k)
                    return i;
                count++;
            }
        }
        return -1;
    }

    int findFirstDuplicateEntry(int[] A) {
        for (int i=0; i<A.length; i++) {
            if (A[Math.abs(A[i])-1]<0)
                return Math.abs(A[i]);
            else {
                A[Math.abs(A[i])-1] = -A[Math.abs(A[i])-1];
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        /*
        Input: n = 12, k = 3 Output: 3
        Input: n = 7, k = 2 Output: 7
        Input: n = 4, k = 4 Output: -1
        * */

        int n=12, k=3;
        System.out.println(k+"th factor of "+n+"="+kthFactor(n,k));

        n=7;
        k=2;
        System.out.println(k+"th factor of "+n+"="+kthFactor(n,k));

        n=4;
        k=4;
        System.out.println(k+"th factor of "+n+"="+kthFactor(n,k));
    }
}
