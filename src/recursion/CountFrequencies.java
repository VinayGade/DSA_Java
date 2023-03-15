package recursion;

import java.util.Arrays;

/*
* Find occurrence of each element in unsorted array
* */
public class CountFrequencies {

    public void countFrequencies(int[] arr){

        int n = arr.length;
        boolean[] visited = new boolean[n];

        Arrays.fill(visited, false);

        for(int i=0; i<n; i++){

            int count = 1;
            if(!visited[i]){
                for (int j = i+1; j < n; j++) {
                    if(arr[i] == arr[j]){
                        visited[i] = true;
                        count++;
                    }
                }
            }
            System.out.println(arr[i] + " " + count);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 10, 6, 7, 6, 4, 10, 10, 2, 3, 1, 7, 6, 3};

        CountFrequencies frequencies = new CountFrequencies();
        frequencies.countFrequencies(arr);

    }
}
