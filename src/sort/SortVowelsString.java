package sort;


import java.util.*;

// LeetCode 2785. (Medium) Sort Vowels in a String
public class SortVowelsString {

    //simple way
    public String sortVowelsEasy(String s) {
        int n = s.length();
        ArrayList<Character> vow = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) { // condition to check for vowel
                vow.add(ch);
                pos.add(i); // storing positions of vowel
            }
        }

        Collections.sort(vow);

        char[] answer = s.toCharArray();
        for (int i = 0; i < pos.size(); i++) {
            answer[pos.get(i)] = vow.get(i);
        }

        return new String(answer);
    }


    //PriorityQ
    public static String sortVowelsPriorityQ(String s) {
        char[] str = s.toCharArray();
        PriorityQueue<Character> pq = new PriorityQueue<Character>();

        String vowels = "AEIOUaeiou";
        for (char c : str)
            if (vowels.indexOf(c) != -1)
                pq.offer(c);

        for (int i=0; i < str.length; i++)
            if (vowels.indexOf(str[i]) != -1)
                str[i] = pq.poll();

        return new String(str);
    }

    //best case solution : time and space complexity
    public String sortVowelsBest(String s) {
        int[] vowelCount = new int[11];
        int[] countIndexMap = new int[128];
        char[] result = s.toCharArray();
        char[] charMap = "AEIOUaeiou".toCharArray();

        for (int i = 0; i < charMap.length; i++)
            countIndexMap[charMap[i]] = i + 1;

        for (char c : result)
            vowelCount[countIndexMap[c]]++;
        int j = 1;
        int i = 0;

        while (j < vowelCount.length) {
            if (vowelCount[j] > 0)
                while (i < result.length) {
                    if (countIndexMap[result[i]] == 0) {
                        i++;
                        continue;
                    }
                    vowelCount[j]--;
                    result[i++] = charMap[j - 1];
                    break;
                }
            else
                j++;
        }
        return new String(result);
    }

    // brute force
    public String sortVowels1(String s) {
        int n = s.length();
        String vowelSubString = "";
        char[] result = new char[n];
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(isVowel1(c))
                vowelSubString+=c;
            result[i]=c;
        }
        //sort vowelsubstr in asc order
        char[] vowelsInSubStr = vowelSubString.toCharArray();
        Arrays.sort(vowelsInSubStr);

        //replace vowels
        int j=0;
        for(int i=0; i<n; i++){
            if(isVowel1(result[i])){
                result[i]=vowelsInSubStr[j];
                j++;
            }
        }
        return String.valueOf(result);
    }
    private boolean isVowel1(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    private boolean isVowel(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    //TODO fix code to fetch corresponding vowels from the map
    public String sortVowels(String s) {

        String vowelString = "AEIOUaeiou";
        Map<Character, Integer> vowelFrequencyMap = vowelFrequencies(s);

        StringBuilder result = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(isVowel(c)){
                /*
               for(Map.Entry<Character, Integer>)
               result.append()

                 */
            }
            result.append(c);
        }
        return result.toString();
    }

    private Map<Character, Integer> vowelFrequencies(String s){
        Map<Character, Integer> vowelFrequencyMap = new TreeMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(isVowel(c)) {
                if (vowelFrequencyMap.containsKey(c))
                    vowelFrequencyMap.put(c, vowelFrequencyMap.get(c) + 1);
                else
                    vowelFrequencyMap.put(c, 1);
            }
        }
        return vowelFrequencyMap;
    }
    public static void main(String[] args) {

        String s = "lEetcOde";
        String result = sortVowelsPriorityQ(s);
        System.out.println(result);
    }
}
