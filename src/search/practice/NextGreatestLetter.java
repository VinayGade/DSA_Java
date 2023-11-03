package search.practice;

import java.util.Arrays;

// 744. Find Smallest Letter Greater Than Target
public class NextGreatestLetter {

    public static char nextGreatestLetter(char[] letters, char target) {

        int n = letters.length;
        Arrays.sort(letters);
        // binary search for target

        if(target<letters[0] || target>=letters[n-1]) {
            return letters[0];
        }
        else{
            int low = 0;
            int high = n-1;
            char smallest = letters[0];
            while(low <= high){
                int mid = low + (high - low) / 2;
                if(letters[mid] == target){
                    while(letters[mid+1] == target){
                        mid++;
                    }
                    smallest = letters[mid+1];
                    break;
                }else if(target < letters[mid]){
                    if(target >= letters[mid-1]){
                        smallest = letters[mid];
                        break;
                    }
                    high = mid - 1;
                }else{
                    if(target <= letters[mid+1]){
                        smallest = letters[mid+1];
                        break;
                    }
                    low = mid + 1;
                }
            }
            return smallest;
        }
    }

    public static char nextGreatestLetterOptimized(char[] letters, char target) {

        int n = letters.length;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(target > letters[mid])
                low = mid + 1;

            else if(target < letters[mid])
                high = mid - 1;

            else
                low = mid + 1;
        }
        return  letters[low % n];
    }

    public static void main(String[] args) {

        // letters = ["c","f","j"], target = "a"
        // letters = ["c","f","j"], target = "c"
        // letters = ["x","x","y","y"], target = "z"
        /* letters =
        ["a","b","c","d","e","f","g","h","j","k","l","m","n","o","p","q","r","s","t","u",
        "v","w","x","y","z"]
        target ="d"
        * */

        char[] letters =
                {'a','b','c','d','e','f','g','h','j','k','l','m','n','o','p','q','r','s','t','u',
                'v','w','x','y','z'};

        char target ='d';

        char next = nextGreatestLetterOptimized(letters, target);

        System.out.println("target = "+target+", Next greater element = "+next);
    }
}
