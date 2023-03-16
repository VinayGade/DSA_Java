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

            if(visited[i])
                continue;

            int count = 1;
            for (int j = i+1; j < n; j++) {
                if(arr[i] == arr[j]){
                    visited[j] = true;
                    count++;
                }
            }

            System.out.println(arr[i] + " " + count);
        }
    }

    private void frequencies(int [] nums){

        int count = 0;
        int n = nums.length;
        int[] freuencyList = new int[n];

        for(int i=0; i<n; i++){

            count = 1;
            for(int j=i+1; j<n; j++){

                if(nums[i] == nums[j]){

                    count++;
                    freuencyList[j] = 0;
                }
            }

            if(freuencyList[i] != 0)
                freuencyList[i] = count;
        }

        System.out.println("The elements and their occurences are");
        for(int i = 0; i<nums.length; i++)
            if(freuencyList[i]>=1)
                System.out.println("Element="+nums[i]+", Frequency="+freuencyList[i]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 10, 6, 7, 6, 4, 10, 10, 2, 3, 1, 7, 6, 3};

        CountFrequencies frequencies = new CountFrequencies();
        frequencies.countFrequencies(arr);

    }
}