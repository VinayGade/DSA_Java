package array.math.string;

import java.util.Scanner;

public class password {

    /*
    Chef is planning to setup a secure password for his Codechef account.
    For a password to be secure the following conditions should be satisfied:

    1. Must contain at least 1 character [a-z] and [A-Z]
    2. Must contain at least 1 digit [0-9]
    3. Must contain at least 1 special character [@, #, %, &, ?]
    4. must be of 10 chars in length
    * */

    public static boolean isValidPassword(String password){
        char[] pass = password.toCharArray();
        int n = pass.length;
        if(n < 10)
            return false;
        int charCount = 0;
        int capitalCount = 0;
        int digitCount = 0;
        int specialCharCount = 0;

        for(int i=0; i<n; i++){
            if(pass[i] > 64 && pass[i] < 91)
                capitalCount++;
            else if(pass[i] > 96 && pass[i] < 123)
                charCount++;
            else if(pass[i] >= 48 && pass[i] <= 57) {
                if(i>0 && i<(n-1))
                    digitCount++;
            }else if(pass[i] == '&' || pass[i] == '#' || pass[i] == '%' || pass[i] == '@' || pass[i] == '?') {
                if(i>0 && i<(n-1))
                    specialCharCount++;
            }else
                return false;
        }
        return (charCount >= 1 && capitalCount >= 1 && digitCount >= 1 && specialCharCount >= 1);
    }

    public static boolean isValidPassword2(String password) {
        char[] pass = password.toCharArray();
        int n = pass.length;
        if (n < 10)
            return false;

        boolean hasLower = false;
        boolean hasUpperInside = false;
        boolean hasDigitInside = false;
        boolean hasSpecialInside = false;

        for (int i = 0; i < n; i++) {
            if ('a' <= pass[i] && pass[i] <= 'z') {
                hasLower = true;
            } else if ('A' <= pass[i] && pass[i] <= 'Z') {
                if (i > 0 && i < (n - 1)) {
                    hasUpperInside = true;
                }
            } else if ('0' <= pass[i] && pass[i] <= '9') {
                if (i > 0 && i < (n - 1)) {
                    hasDigitInside = true;
                }
            } else if (pass[i] == '&' || pass[i] == '#' || pass[i] == '%' || pass[i] == '@' || pass[i] == '?') {
                if (i > 0 && i < (n - 1)) {
                    hasSpecialInside = true;
                }
            } else {
                return false;
            }
        }

        return hasLower && hasUpperInside && hasDigitInside && hasSpecialInside;
    }

    public static boolean checkpas(String str){
        if(str.length()<10){
            return false;
        }
        boolean digit=false;
        boolean upper=false;
        boolean lower=false;
        boolean isspecial=false;
        String special="@#%&?";
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(Character.isLowerCase(ch)){
                lower=true;
            }
            if(i>0&&i<str.length()-1){
                if(Character.isUpperCase(ch)){
                    upper=true;
                }
                if(Character.isDigit(ch)){
                    digit=true;
                }
                if(special.indexOf(ch)!=-1){
                    isspecial=true;
                }
            }
        }
        return lower&&upper&&digit&&isspecial;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            String password = scanner.next();
            String valid = isValidPassword(password) ? "YES" : "NO";
            System.out.println(valid);
        }
    }
}
