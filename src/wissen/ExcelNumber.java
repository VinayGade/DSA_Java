package wissen;

import java.util.HashMap;
import java.util.Map;

public class ExcelNumber {

    /*
    A - 1

    input - 51
    *
    * */
    public static void main(String[] args) {
        int x = 51;
        String s = decode(x);
        System.out.println(s);
    }

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
