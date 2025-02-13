package array.math.string;

// LeetCode 1668. Maximum Repeating Substring

/*
For a string sequence, a string word is k-repeating if word concatenated k times is a substring of
sequence. The word's maximum k-repeating value is the highest value k where word is k-repeating
in sequence. If word is not a substring of sequence, word's maximum k-repeating value is 0.

Given strings sequence and word, return the maximum k-repeating value of word in sequence.

Example 1:

Input: sequence = "ababc", word = "ab"
Output: 2
Explanation: "abab" is a substring in "ababc".
Example 2:

Input: sequence = "ababc", word = "ba"
Output: 1
Explanation: "ba" is a substring in "ababc". "baba" is not a substring in "ababc".
Example 3:

Input: sequence = "ababc", word = "ac"
Output: 0
Explanation: "ac" is not a substring in "ababc".
* */

public class MaximumRepeatingSubString {

    /*
    public int maxRepeating(String sequence, String word) {
        String found = word;
        int count = 0;
        while(sequence.contains(found)){
            found += word;
            count++;
        }
        return count;
    }
    */
    public int maxRepeating(String sequence, String word) {
        String key = word;
        int count = 0;
        int begin = 0;
        while(true){
            int i = sequence.substring(begin).indexOf(key);
            if(i == -1)
                return count;
            else{
                count++;
                //key+=word;
                key = key.concat(word);
                begin = i;
            }
        }
    }

    public static void main(String[] args) {

        MaximumRepeatingSubString repeating = new MaximumRepeatingSubString();

        String sequence = "ababc";
        String word = "ab";
        int count = repeating.maxRepeating(sequence, word);
        System.out.println(count);
    }
}
