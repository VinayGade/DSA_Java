package search.practice;

/*
Police and Thieves

Given an array arr[], where each element contains either a 'P' for policeman or a 'T'
for thief. Find the maximum number of thieves that can be caught by the police.
Keep in mind the following conditions :
Each policeman can catch only one thief.
A policeman cannot catch a thief who is more than k units away from him.

Input: arr[] = ['P', 'T', 'T', 'P', 'T'], k = 1
Output: 2
Explanation: Maximum 2 thieves can be caught.
First policeman catches first thief and second police man can catch either second or third thief.

Input: arr[] = ['T', 'T', 'P', 'P', 'T', 'P'], k = 2
Output: 3
Explanation: Maximum 3 thieves can be caught.
* */

public class PoliceTheives {

    static int catchThieves(char[] arr, int k) {

        int n = arr.length;
        int police = 0, thief = 0, count = 0;

        while(police < n && thief < n){
            while(police < n && arr[police] != 'P')
                police++;

            while(thief < n && arr[thief] != 'T')
                thief++;

            if(police < n && thief < n){
                if(Math.abs(police - thief) <= k){
                    count++;
                    police++;
                    thief++;
                }else if(thief < police){
                    thief++;
                }else{
                    police++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        char[] arr = {'T', 'T', 'P', 'P', 'T', 'P'};
        int k = 2;

        int count = catchThieves(arr, k);
        System.out.println(count);
    }
}
