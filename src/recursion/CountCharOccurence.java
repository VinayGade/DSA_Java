package recursion;

import java.util.HashMap;
import java.util.Map;

public class CountCharOccurence {

    private int charOccurence(String S, char c, int i){

        if (i >= S.length())
            return 0;

        int count = S.charAt(i) == c ? 1 : 0;
        return count + charOccurence(S, c, i+1);
    }

    public int[] charFrequency( String str){

        int i=0;
        int length = str.length();
        int [] counter = new int[256];

        while(i < length){

            counter[(int) str.charAt(i)]++;
            i++;
        }
        return counter;
    }

    public void displayCharFrequency( int[] counter){
        for( int j=0; j<counter.length; j++){
            if(counter[j] != 0)
                System.out.println("[ "+(char)j+"] = "+counter[j]);
        }

    }

    public Map<Character, Integer> computeCharFrequency(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for(char c: str.toCharArray())
            frequencyMap.put( c, frequencyMap.getOrDefault(c, 0) + 1);

        return frequencyMap;
    }

    public static void main(String[] args) {
        String str = "java se 8 lambda expression";

        char key = 'a';

        CountCharOccurence freq = new CountCharOccurence();

        int frequencyKey = freq.charOccurence(str, key, 0);

        System.out.println("char :"+key+", frequency = "+frequencyKey);

        int[] frequencyArr = freq.charFrequency(str);

        freq.displayCharFrequency(frequencyArr);

        System.out.println("\nCompute Character frequency using Java 8 Map features:\n ");

        Map<Character, Integer> frequencyMap = freq.computeCharFrequency(str);

        frequencyMap.forEach(
                (character, frequency) ->
                    System.out.println("character = " + character + ", frequency = "+frequency)
        );
    }


}
