package trie;

public class BruteForcePatternMatching {

    public int findBruteForce(char[] text, char[] pattern){

        int n=text.length;
        int m=pattern.length;

        for(int i=0; i<(n-m); i++){
            int k = 0;

            while(k<m && text[i+k]==pattern[k])
                k++;

            if(k==m)
                return i;
        }
        return -1;
    }

    public int searchBruteForce(String text, String pattern){

        int n = text.length();
        int m = pattern.length();

        for(int i=0; i<n; i++){

            int k=0;

            while(k<m && text.charAt(i+k) == pattern.charAt(k))
                k++;

            if(k==m)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        String text = "abacaabaccabacabaabb";
        String pattern = "abacab";

        //text = abacaabaccabacabaabb
        //pattern = abacab

        //text = abracadabra
        //pattern = bra

        BruteForcePatternMatching bfpm = new BruteForcePatternMatching();
        int index = bfpm.findBruteForce(text.toCharArray(), pattern.toCharArray());

        int foundAt = bfpm.searchBruteForce(text, pattern);
        System.out.println("pattern "+pattern+" is found in text at index "+index);

        System.out.println("pattern "+pattern+" is found at "+foundAt);
    }
}
