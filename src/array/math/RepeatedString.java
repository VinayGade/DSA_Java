package array.math;

//HackerRank: RepeatedString
/*
There is a string, s , of lowercase English letters that is repeated infinitely many times.
Given an integer, n , find and print the number of letter a's in the
first n letters of the infinite string.

eg.
s='abcac'
n=10
* */
public class RepeatedString {

    public static long repeatedString(String s, long n) {
        int count = 0;
        long stringLength = s.length();
        for(int i=0; i<stringLength; i++){
            if(s.charAt(i)=='a')
                count++;
        }
        System.out.println("count="+count);
        long repetitions = n/stringLength;

        System.out.println("repetitions="+repetitions);

        long totalCount = repetitions * count;

        System.out.println("totalCount="+totalCount);

        long leftLength = n - (repetitions * stringLength);

        System.out.println("leftLength="+leftLength);

        int extra = 0;
        for(int i=0; i<leftLength; i++){
            if(s.charAt(i)=='a')
                extra++;
        }

        System.out.println("extra="+extra);

        totalCount+=extra;
        return totalCount;
    }
    public static void main(String[] args) {
        String s="abcac";
        long n=122;
        long count = repeatedString(s, n);
        System.out.println(count);
    }
}
