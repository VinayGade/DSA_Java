package recursion;

public class Palindrome {

    private static void reverse(char[] str, int start, int end){
        if(start < end){
            char temp=str[start];
            str[start]=str[end];
            str[end]=temp;
            reverse(str, start+1, end-1);
        }
    }

    // Leetcode 125. Valid Palindrome
    private static boolean isPalindrome(String string){
        string = string.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        char[] str = string.toCharArray();
        reverse(str, 0, string.length()-1);
        return string.equalsIgnoreCase(String.valueOf(str));
    }

    public static boolean isPalindrome(String s, int n) {   // method overloading
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        char[] str = s.toCharArray();
        //reverse(str, 0, s.length()-1);
        return isValidPalindrome(str, 0, s.length()-1);
    }

    private static boolean isValidPalindrome(char[] str, int start, int end){
        if(start < end){
            if(str[start] != str[end])
                return false;
            return isValidPalindrome(str, start+1, end-1);
        }
        return true;
    }
    public static void main(String[] args) {

        String[] testCases = {
                "abracadabra",
                "racecar",
                "gohangasalamiimalasagnahog",
                "amanaplanacanalpanama",
                "aaa",
                "aza",
                "ABCBA",
                "saippuakivikauppias",
                "borroworrob",
                "wow",
                "UFO tofu",
                "tacocat",
                "never odd or even",
                "dont nod"
        };

        for(String test: testCases){
            System.out.println(test+" : "+isPalindrome(test));
        }
    }
}