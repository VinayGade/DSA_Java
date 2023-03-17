package recursion;

import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class ReverseWordsSentence {

    void reverseWords(String str) {
        Stack<Character> st=new Stack<Character>();

        // Traverse given string and push all
        // characters to stack until we see a space.
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) != ' ')
                st.push(str.charAt(i));

                // When we see a space, we print
                // contents of stack.
            else {
                while (st.empty() == false) {
                    System.out.print(st.pop());

                }
                System.out.print(" ");
            }
        }

        // Since there may not be space after
        // last word.
        while (st.empty() == false) {
            System.out.print(st.pop());

        }
    }

    public void printWords(String str)
    {
        // word variable to store word
        String word;

        // making a string stream
        StringTokenizer iss = new StringTokenizer(str);

        // Read and print each word.
        while (iss.hasMoreTokens()){
            word = iss.nextToken();
            System.out.print(new StringBuilder(word).reverse().toString() + " ");
        }
    }

    public String reverseEachWord(String sentence){
        // Splitting the string based on space and reverse each part
        // and then join
        return Arrays.asList(sentence.split(" "))
                .stream()
                .map(s -> new StringBuilder(s).reverse())
                .collect(Collectors.joining(" "));
    }

    static String makeReverse(String str) {
        StringBuffer s = new StringBuffer(str);
        str = s.reverse().toString();
        String [] rev = str.split(" ");
        StringBuffer reverse = new StringBuffer();
        for(int i = rev.length - 1; i >= 0; i--) {
            reverse.append(rev[i]).append(" ");
        }
        return reverse.toString();
    }

    public String reverseSentenceWords(String originalStr){
        String words[] = originalStr.split("\\s");
        String reversedString = "";

        for (int i = 0; i < words.length; i++)
        {
            String word = words[i];
            String reverseWord = "";
            for (int j = word.length() - 1; j >= 0; j--) {
                reverseWord = reverseWord + word.charAt(j);
            }
            reversedString = reversedString + reverseWord + " ";
        }
        return reversedString;
    }

    public static void main(String[] args) {

        ReverseWordsSentence reverseWords = new ReverseWordsSentence();

        String sentence = "Java-11 is very efficient than Java-6";

        String reverse = reverseWords.reverseEachWord(sentence);

        String reversed = reverseWords.reverseSentenceWords(sentence);

        System.out.println("Original Sentence = "+sentence);

        System.out.println("Reverse each word = "+reverse);

        System.out.println("Reverse each word = "+reversed);

    }

}
