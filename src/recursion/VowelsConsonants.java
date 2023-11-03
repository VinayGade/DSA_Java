package recursion;

public class VowelsConsonants {

    // String is valid if | consonants(S) | > | vowels(S) |
    private static boolean isValid(String S){
        int n = S.length();
        //int v = vowelCount(S.toCharArray(), 0, 0, n, "aeiouAEIOU");
        int v = countVowels(S, n);
        int s = countSpaces(S, ' ', 0); // | spaces(S) |
        int c = n-(v+s);                        // | consonants(S) |
        System.out.print(" n= "+n+" | consonants(S) | ="+c+" | vowels(S) | = "+v+" | spaces(S) | = "+s);
        return v >= c;
    }

    private static int vowelCount(char[] S, int i, int c, int n, String vowel){
        if(i<n){
            if(vowel.contains(String.valueOf(S[i])))
                c=1;
            return c + vowelCount(S, i+1, c, n-1, vowel);
        }else
            return 0;
    }

    // GFG solution to compute | vowels(S) |
    static int isVowel(char ch) {
        ch = Character.toUpperCase(ch);
        if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' ||
                ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
            return 1;
        else return 0;
    }

    static int countVowels(String S, int n) {
        if (n == 1)
            return isVowel(S.charAt(n-1));   // n-1 == 0

        return countVowels(S, n-1) + isVowel(S.charAt(n - 1));
    }

    private static int countSpaces(String S, char space, int i){
        if (i >= S.length())
            return 0;

        int count = S.charAt(i) == space ? 1 : 0;
        return count + countSpaces(S, space, i+1);
    }

    public static void main(String[] args) {

        String[] testCases = {
                "potsandpans",
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
                "dontnod",
                "mission impossible",
                "Casino Royale",
                "No Time To Die"
        };

        for(String test: testCases){
            System.out.println(test+" : "+isValid(test));
        }
    }
}
