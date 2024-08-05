package array.math;

import java.util.Scanner;

/*
5
hello world
this is a CODECHEF problem
WELCOME to the JUNGLE
the quick BROWN fOx
programming in PYTHON
* */

public class TitleCase {

    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < t; i++) {
            String sentence = scan.nextLine();
            String titleCase = sentenceCase(sentence);
            System.out.println(titleCase);
        }
    }

    static String sentenceCase(String sentence) {
        String titleCase = "";

        String[] words = sentence.split(" ");
        for (String word: words) {
            if (word.isEmpty())
                continue;

            //lower case: 97 - 122
            //UPPER CASE: 65 - 90
            char first = word.charAt(0);
            if (word.toLowerCase().equals(word))
                   // && first >= 97 && first <= 122)
            {
                char upper = (char)(first - 32);
                //replace(char oldChar, char newChar)
                word = word.replace(first, upper);

            } else {
                // Check if the word is an acronym (all uppercase)
                boolean isAcronym = true;
                for (int i = 0; i < word.length(); i++) {
                    if (!Character.isUpperCase(word.charAt(i))) {
                        isAcronym = false;
                        break;
                    }
                }
                String other = "";
                if (!isAcronym) {
                    other += Character.toUpperCase(word.charAt(0));
                    other = other.concat(word.substring(1).toLowerCase());
                    word = other;
                }
            }
            titleCase = titleCase.concat(word + " ");
        }
        return titleCase.trim(); // Trim the trailing space
    }
}