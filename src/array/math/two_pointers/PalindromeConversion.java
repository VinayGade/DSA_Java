package array.math.two_pointers;

/*
Convert to Palindrome

Given a string A consisting only of lowercase characters, we need to check whether
it is possible to make this string a palindrome after removing exactly one character
from this.
If it is possible then return 1 else return 0.

Example Input
Input 1:
 A = "abcba"

Input 2:
 A = "abecbea"

Example Output
Output 1:
1
Output 2:
0

* */
public class PalindromeConversion {

    static int solve(String A) {
        int i=0;
        int j=A.length()-1;
        while(i<=j){
            if(A.charAt(i) != A.charAt(j)){
                boolean isPossible = isPalindrome(A.substring(i,j)) || isPalindrome(A.substring(i+1,j+1));
                if(isPossible) return 1;
                else return 0;
            }
            i++;
            j--;
        }
        return 1;
    }

    static boolean isPalindrome(String str){
        int i=0;
        int j=str.length()-1;
        while(i<=j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String A = "abecbea";  //"abcba"
        String convertible = solve(A) == 1 ? "YES": "NO";
        System.out.println("String convertible to Palindrome? " +convertible);
    }
}
