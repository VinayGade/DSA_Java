package recursion;

public class CountSubString {

    static int countSubstring(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        // Base Case
        if (n1 == 0 || n1 < n2)
            return 0;

        // Recursive Case
        // Checking if the first
        // substring matches
        if (str1.substring(0, n2).equals(str2))
            return countSubstring(str1.substring(1), str2) + 1;

        // Otherwise, return the count
        // from the remaining index
        return countSubstring(str1.substring(1), str2);
    }

    public static void main(String args[]){
        String str1 = "geeksforgeeks";
        String str2 = "geeks";

        System.out.println(countSubstring(str1, str2));

        String str3 = "abracadabra";
        String str4 = "abra";

        System.out.println(countSubstring(str3, str4));

        String str5 = "aaaaa";
        String str6 = "aaa";

        System.out.println(countSubstring(str5, str6));
    }
}
