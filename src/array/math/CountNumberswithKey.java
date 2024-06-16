package array.math;

public class CountNumberswithKey {
    //You are given a number n, Return the count of total numbers
    // from 1 to n containing key as a digit.      ...1 <= n <= 10^5

    /*
    Input: n = 9  key = 4
Output: 1
Explanation: 4 is the only number between 1 to 9 which contains 4 as a digit.

Input: n = 44  key = 4
Output: 9
Explanation: 4, 14, 24, 34, 40, 41, 42, 43, 44.
there are total 9 numbers containing 4 as a digit.
    * */

    //Hint: This problem is very similar to reverse number logic

    public static int countNumberswith4(int n) {

        int MAX_LENGTH = 6;  // ...1 <= n <= 10^5 ( = 100000)
        int KEY = 4;

        int count = 0;

        // iterate over 1 to N
        for(int i=KEY; i<=n; i++){
            if(contains4(i, KEY))
                count++;
        }
        return count;
    }

    //static int reverse(int n)
    static boolean contains4(int n, int key)
    {
        // reversed number
        //int rev = 0;
        // remainder
        int rem;

        while (n > 0) {
            rem = n % 10;
            if(rem == key)
                return true;
            //rev = (rev * 10) + rem;
            n = n / 10;
        }

        return false;
    }

    public static void main(String[] args) {
        int n= 44;
        int count = countNumberswith4(n);
        System.out.println(count);
    }
}
