package sort;

import java.util.HashMap;
import java.util.Map;

//LeetCode 1859 (Easy) : Sorting the Sentence

/*
A sentence is a list of words that are separated by a single space with no leading or
trailing spaces. Each word consists of lowercase and uppercase English letters.

A sentence can be shuffled by appending the 1-indexed word position to each word
then rearranging the words in the sentence

Example 1:
Input: s = "is2 sentence4 This1 a3"
Output: "This is a sentence"

Example 2:
Input: s = "Myself2 Me1 I4 and3"
Output: "Me Myself and I"
* */
public class SortSentence {

    public static String sortSentence(String s){
        //Map to store word in correct order
        Map<Integer, String> indexWordMap = new HashMap<>();

        //split each word based on space
        for(String word : s.split(" ")){
            int last = word.length()-1;

            //get the word and index separate
            int index = word.charAt(last) - '0';
            String actualWord = word.substring(0, last);
            indexWordMap.put(index, actualWord);
        }

        //Build actual string
        StringBuilder sentence = new StringBuilder();
        for(Map.Entry<Integer, String> entry : indexWordMap.entrySet()){
            sentence.append(entry.getValue());
            sentence.append(" ");
        }
        return sentence.toString().trim();
    }

    public static void main(String[] args) {
        String s = "Myself2 Me1 I4 and3";
        String sentence = sortSentence(s);
        System.out.println(sentence);
    }
}
