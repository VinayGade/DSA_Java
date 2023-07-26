package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinMaxSum {

        /*
         * Complete the 'miniMaxSum' function below.
         *
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

    public static void miniMaxSum(List<Integer> arr) {


        int n=arr.size();
        long total=0;
        int smallest = arr.get(0);
        int largest = arr.get(n-1);
        /*
        1. total = sum of all elements.
            i. find min
            ii. find max
        2. Max-sum = total - min
        3. Min-sum = total = max
        */

        for(int x: arr){
            total+=x;
            if(x<smallest)
                smallest = x;
            if(x>largest)
                largest = x;
        }
        System.out.println((total - largest)+" "+(total - smallest));
    }

        public static void main(String[] args) throws IOException {
            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            List<Integer> arr = Arrays.asList(7, 69, 2, 221, 8974);
            /*
            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

             */

            miniMaxSum(arr);

            //bufferedReader.close();
        }
}
