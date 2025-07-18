package hashing;

/*

Group Anagrams:

Given an array A of N strings, return all groups of strings that are anagrams.

Represent a group by a list of integers representing the index(1-based) in the original list.
Look at the sample case for clarification.

NOTE: Anagram is a word, phrase, or name formed by rearranging the letters, such as 'spar',
formed from 'rasp'.

Input Format
The first and only argument is an integer array A.

Output Format
Return a two-dimensional array where each row describes a group.

Note:

Ordering of the result :
 You should not change the relative ordering of the strings within the group suppose
 within a group containing A[i] and A[j], A[i] comes before A[j] if i < j.

Example Input
Input 1:

 A = [cat, dog, god, tca]

Input 2:

 A = [rat, tar, art]

 Example Output
Output 1:

 [ [1, 4],
   [2, 3] ]
Output 2:

 [ [1, 2, 3] ]

Example Explanation
Explanation 1:

 "cat" and "tca" are anagrams which correspond to index 1 and 4 and "dog" and "god"
  are another set of anagrams which correspond to index 2 and 3.
 The indices are 1 based ( the first element has index 1 instead of index 0).
Explanation 2:

 All three strings are anagrams.
*
* */

import java.util.*;

public class GroupAnagramsII {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {

        Map<String, Integer> map = new LinkedHashMap<>();
        ArrayList<ArrayList<Integer>> groupedAnagrams = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < A.size(); i++) {
            String key = sortChars(A.get(i));

            if(map.containsKey(key)){
                groupedAnagrams.get(map.get(key)).add(i + 1);
            }else{
                map.put(key, groupedAnagrams.size());
                ArrayList<Integer> newGroup = new ArrayList<>();
                newGroup.add(i + 1);
                groupedAnagrams.add(newGroup);
            }
        }
        return groupedAnagrams;
    }

    String sortChars(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static void main(String[] args) {
        GroupAnagramsII sol = new GroupAnagramsII();
        List<String> input1 = Arrays.asList("cat", "dog", "god", "tca");
        System.out.println(sol.anagrams(input1));

        List<String> input2 = Arrays.asList("rat", "tar", "art");
        System.out.println(sol.anagrams(input2));
    }
}
