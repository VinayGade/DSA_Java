package hashing;

import java.util.LinkedHashMap;
import java.util.Map;

public class CaesarCipher {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static void main(String[] args) {

        String plainText = "The Prisoner of Birth, Jeffry Archer";
        int key = 4;
        String cypherText = caesarCipher(plainText, key);
        System.out.println(cypherText);
    }

    public static String caesarCipher(String s, int k) {

        String cypherText="";
        char[] alp = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] ALPH = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[]  cypherTextArr = new char[s.length()];
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < 26; j++){

                char plainText = s.charAt(i);

                if (plainText == alp[j]){
                    cypherTextArr[i] = alp[(j + k) % 26];
                    break;
                } else if (plainText == ALPH[j]){
                    cypherTextArr[i] = ALPH[(j + k) % 26];
                    break;
                } else
                    cypherTextArr[i] = plainText;
            }
        }

        for(int i=0; i<cypherTextArr.length; i++)
            cypherText += cypherTextArr[i];

        return cypherText;
    }

    public static String caesarCipher1(String source, int key) {

        String encrypted = "";

        /*
        Unicode. values
        A - Z : 65 - 90.   ... CH > 90   CH = 65
        a - z : 97 - 122.  ... ch > 122   ch = 97
        */
        return encrypted;
    }

    public static LinkedHashMap<Character, Character> encryption(String source, int key){

        char[] plainText = source.toCharArray();
        Map<Character, Character> cypherText = new LinkedHashMap<>();

        for(int i = 0; i<plainText.length; i++){
             if(plainText[i]<90 || plainText[i]>122)
                 cypherText.put(plainText[i], plainText[i]);

             else if(!cypherText.containsKey(plainText[i])){

                 char encrypted = (char)((int)plainText[i] + key);
                 int shift = 1;
                 if(encrypted>90 && encrypted<97){


                 }

                 cypherText.put(plainText[i], (char)((int)plainText[i] + key));
             }

        }
        return null;
    }
}
