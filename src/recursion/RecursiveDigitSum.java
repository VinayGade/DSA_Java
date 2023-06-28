package recursion;

import java.io.*;

public class RecursiveDigitSum {

    /*
    HackerRank
    Prepare > Algorithms > Recursion
    Recursive Digit Sum
    * */

    public static int superDigit(String n, int k) {
        //use long to have a bigger range for solving bigger problems
        long sum = 0;
        //To Avoid heap memory OOM, get get the sum from the input string and do it k times.
        //It will have the same effect of making string k times and summing.
        for(int i = 0; i< n.length(); i++){
            sum += Integer.valueOf(n.charAt(i) - 48);
        }
        sum *= k;
        //Call the recursive method
        return helper(sum);
    }

    private static int helper(long n){
        //Check if we have achieved a single digit, then return it.
        if(n < 10)
            return (int)n;

        long sum = 0;
        //Get the sum of all the digits
        while(n>0) {
            sum+= n%10;    //12345 %10 => 5, so we will keep on adding the remainder (last digit)
            n = n/10;    //12345 /10 => 1234
        }
        //call the recursive function with the sum
        return helper(sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new
                FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = RecursiveDigitSum.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
