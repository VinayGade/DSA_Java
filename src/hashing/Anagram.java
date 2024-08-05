package hashing;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {

    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            String A = scanner.next();
            String B = scanner.next();
            String result = anagram(A, B) ? "YES" : "NO";
            System.out.println(result);
        }
    }

    static boolean anagram(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        int[] count = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++)
            if (count[i] != 0)
                return false;
        return true;
    }

    static boolean isAnagram(String A, String B) {
        int n = A.length();
        int m = B.length();
        if (n != m)
            return false;
        Map<String, Long> frequencyA = characterFrequency(A);
        Map<String, Long> frequencyB = characterFrequency(B);
        return frequencyA.equals(frequencyB);
    }

    public static boolean areAnagrams(String sample , String sample2){
        boolean result = true;
        if(sample.length()!=sample2.length()){
            result = false;
        }else{
            char arr[] = sample.toCharArray();
            char arr2[] = sample2.toCharArray();
            Arrays.sort(arr);
            Arrays.sort(arr2);
            for(int i=0;i<sample.length();i++){
                if(arr[i]!=arr2[i]){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    static Map<String, Long> characterFrequency(String string){

        String[] stringChars = string.split("");

        Map<String, Long> frequencyMap = Arrays.stream(stringChars)
                .filter(s -> !s.equals(" "))
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()));

        return frequencyMap;
    }
}
