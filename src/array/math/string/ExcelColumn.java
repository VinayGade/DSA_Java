package array.math.string;

// LeetCode 171: Excel Sheet Column number

public class ExcelColumn {

    static int titleToNumber(String s){

        if(s.isEmpty())
            return -1;

        int sum = 0;

        for(char c: s.toUpperCase().toCharArray()){
            sum *= 26;
            sum += c - 'A' + 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        String column ="AB";
        int col = titleToNumber(column);
        System.out.println(col);
    }
}
