package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        int n = 19; // n = 2, 11
        System.out.println(n + " is happy ?"+isHappy(n));
    }

    public static boolean isHappy(int n) {
        List<Integer> digits = findDigits(n);
        int sum = 0;
        outer:while(true){
            sum = 0;
            for(int digit: digits){
                sum = sum + digit * digit;
                if(sum<10 && digits.get(digits.size()-1)==digit)
                    break outer;
            }
            digits = findDigits(sum);
        }
        return sum == 1;
    }

    public static List<Integer> findDigits(int n){
        List<Integer> digits = new ArrayList<>();
        while(n>0){
            int digit = n%10;
            digits.add(digit);
            n/=10;
        }
        return digits;
    }

    public boolean isHappy1(int n) {
        // Create a set to keep track of the numbers that have already been seen
        Set<Integer> seen = new HashSet<>();

        // Loop until either n becomes 1 (in which case n is a happy number) or n is seen again (in which case n is not a happy number)

        while (n != 1 && !seen.contains(n)) {
            // Add n to the set of seen numbers
            seen.add(n);

            // Compute the sum of the squares of the digits of n
            int sum = 0;
            while (n != 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            // Update n with the sum of the squares of its digits

            n = sum;
        }

        // If n is 1, it is a happy number; otherwise, it is not
        return n == 1;
    }

    public boolean isHappy2(int n) {

        Set<Integer> numbers = new HashSet<>();

        while(n!=1){

            int current = n;
            int sum = 0;

            while(current != 0){
                int rem = current%10;
                sum+= rem*rem;
                current/=10;
            }

            if(numbers.contains(sum))
                return false;

            n = sum;
            numbers.add(n);
        }
        return true;
    }
}
