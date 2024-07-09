package search.practice;

//CodeChef
public class CheckSquare {

    public static boolean checkSquareSum(long c) {

        // c = x + y
        // 90 = 9 + 81 = 3*3 + 9*9
        // 221 = 100 + 121 = 10*10 + 11*11

        if(c == 1)
            return true;

        boolean flag = false;

        for(int i = 1; i <=(int) Math.sqrt(c); i++){
            long x = (long) i * i;
            long y = c - x;
            if(isPerfectSquare(y)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    // Program to find if x is a
    // perfect square.
    static boolean isPerfectSquare(long num)
    {
        long left = 1, right = num;

        while (left <= right) {
            long mid = (left + right) / 2;

            // Check if mid is perfect square
            if (mid * mid == num) {
                return true;
            }

            // Mid is small -> go right to increase mid
            if (mid * mid < num) {
                left = mid + 1;
            }

            // Mid is large -> to left to decrease mid
            else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int c = 221;
        System.out.println(checkSquareSum(c));
    }
}
