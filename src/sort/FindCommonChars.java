package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonChars {

    public List<String> commonCharacters(String[ ] words){

        int n = words.length;

        List<String> commonChars = new ArrayList<>();

        int[] minFrequencies = new int[26];  // once found char in String then inc ...26 based indexed

        //initialize minFrequencies

        Arrays.fill(minFrequencies, Integer.MAX_VALUE);

        for(String string : words){
            int[] charFrequencies = new int[26];  //frequency of every char in string

            for(char ch : string.toCharArray()){
                charFrequencies[ch - 'a']++;
                // eg. ch = b ,  (int) b =98  (int) a = 97 , b-a =1, ... charFrequencies[1] = freq(b)
            }

            for(int i=0; i<26; i++){
                minFrequencies[i] = Math.min(minFrequencies[i], charFrequencies[i]);
            }
        }

        for(int j = 0; j<26; j++){
            while(minFrequencies[j] > 0){
                commonChars.add("" + (char)(j+'a'));
                minFrequencies[j]--;
            }
        }

        return commonChars;
    }
}
