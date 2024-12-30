package wissen;

import java.util.HashMap;
import java.util.Map;

//LeetCode 171. Excel Sheet Column Number
/*

Given a string columnTitle that represents the column title as appears in an Excel sheet,
return its corresponding column number.

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...

Example 1:

Input: columnTitle = "A"
Output: 1
Example 2:

Input: columnTitle = "AB"
Output: 28
Example 3:

Input: columnTitle = "ZY"
Output: 701

Constraints:

1 <= columnTitle.length <= 7
columnTitle consists only of uppercase English letters.
columnTitle is in the range ["A", "FXSHRXW"].
* */

public class ExcelNumber {

    /*
    A - 1

    input - 51
    *
    * */
    public static void main(String[] args) {
        int x = 51;
        String s = decode(x);
        String title = "AB";
        int column = titleToNumber(title);

        System.out.println("convert title to column number : ");
        System.out.println("title : "+title);
        System.out.println("column : "+column);
        //System.out.println(s);

        int columnNumber = 28;
        String convertedTitle = convertToTitle(columnNumber);

        System.out.println("convert column number to title : ");
        System.out.println("column : "+columnNumber);
        System.out.println("title : "+convertedTitle);
    }

    public static int titleToNumber(String s) {
        if (s == null) return -1;
        int sum = 0;
        // for each loop so we don't need to mess with index values.
        for (char c : s.toUpperCase().toCharArray()) {
            sum *= 26;
            sum += c - 'A' + 1;
        }
        return sum;
    }

    //168. Excel Sheet Column Title
    static String convertToTitle(int columnNumber) {

        StringBuilder output = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;
            char c = (char) (columnNumber % 26 + 'A');
            columnNumber /= 26;
            output.append(c);
        }
        // Reverse the output string...
        // Bcause we have found characters from right to left...
        output.reverse();
        return output.toString();
    }
    /*
    Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
    For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...

    Example 1:

Input: columnNumber = 1
Output: "A"
Example 2:

Input: columnNumber = 28
Output: "AB"
Example 3:

Input: columnNumber = 701
Output: "ZY"


Constraints:

1 <= columnNumber <= 231 - 1
    * */

    static String decode(int x){

        String[] chars = new String[26];

        String column = "";
        //(int)unicode(char)
        //for A -> Z : 66 ...



        if(x<=26){
            char ch = (char)  (64 + x);
            column+=String.valueOf(ch);
        }else{
            String col = String.valueOf(x);
            int n = col.length();
            int i = n-1;
            while(i>=0){
                char d = (char) (col.charAt(i)+64);
                column+=String.valueOf(d);
                i--;
            }
            column = new StringBuffer(column).reverse().toString();
        }
        return column;


        //Map<Character, Integer> map = new HashMap<>();


    }

}
