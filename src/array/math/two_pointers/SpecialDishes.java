package array.math.two_pointers;

import java.util.Scanner;

/*
Input:
3
aba
abac
abcd

Output:
YES
NO
NO
* */
public class SpecialDishes {

    static boolean isSpecial(String dish){
        int n = dish.length();
        boolean isEven = (n%2==0);
        int half = isEven ? n/2 : (n/2 + 1);

        int count = 0;
        int i = 0;
        int j = half;
        while(i < half && j < n){
            //int k = (n%2==0) ? (i+j) : (i+j+1);
            if(dish.charAt(i) != dish.charAt(j)) {
                if(count > 1) {
                    return false;
                }
                count++;
                if(j<(n-1) && dish.charAt(i) == dish.charAt(j+1))
                    i--;
                if(dish.charAt(i+1) == dish.charAt(j))
                    j--;
            }
            i++;
            j++;
        }
	    /*
	    String s1 = dish.substring(0, half);
	    String s2 = dish.substring(half);
	    return s1.equals(s2);
	    */
        return true;
    }

    static boolean isSpecialDish(String str, int n) {

        int half = n / 2;
        if (n % 2 == 0) {
            int k = 1;
            for (int i = 0; i < half; i++) {
                if (str.charAt(i) != str.charAt(half + i)) {
                    k = 0;
                    break;
                }
            }
            return (k == 1);
        } else {
            String str1 = str.substring(0, half + 1);
            String str2 = str.substring(half + 1, n);
            String str3 = str.substring(0, half);
            String str4 = str.substring(half, n);
            int k = 0;
            int r = 0;
            for (int i = 0; i <= half; i++) {
                if (k < half && str1.charAt(i) == str2.charAt(k))
                    k++;
                if (r < half && str4.charAt(i) == str3.charAt(r))
                    r++;
            }
            return (str.length() > 1 && (k == half || r == half));
        }
    }

    public static void main (String[] args) throws Exception{

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0){
            //int N = scan.nextInt();
            String dish = scan.next();
            int N = dish.length();
            String special = isSpecialDish(dish, N) ? "YES" : "NO";
            System.out.println(special);
        }
    }
}

/*
input:
10
qjsriyjsriy
coldycoldy
yfziryfzir
dtoxudkamaq
zkiaekbvrj
bqoaxtwelq
ovxnuovxnu
wmtcswmtcss
fulayfuqlay
uyglsuygls

expected output:
YES
YES
YES
NO
NO
NO
YES
YES
YES
YES

code's output:
NO       *
YES
YES
NO
NO
NO
YES
NO       *
NO       *
YES
* */
