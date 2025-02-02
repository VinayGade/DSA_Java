package search.practice;

import java.util.List;

// LeetCode 33. Search in Rotated Sorted Array
public class RotatedArraySearch {

    static int search(int[] a, int target) {
        //int n = a.length;
        int low = 0;
        int high = a.length - 1;
        //int mid = 0;
        while(low < high){
            int mid = (low + high)/2;
            if(a[mid] > a[high]){
                if(target > a[mid] || target <= a[high])
                    low = mid + 1;
                else
                    high = mid;
            }else{
                if(target > a[mid] && target <= a[high])
                    low = mid + 1;
                else
                    high = mid;
            }
        }
        if(low == high && target != a[low])
            return -1;
        return low;
    }

    // Search in Rotated List

    public int search(final List<Integer> a, int target) {

        //int n = a.length;
        int low = 0;
        int high = a.size() - 1;
        //int mid = 0;
        while(low < high){
            int mid = (low + high)/2;
            int middle = a.get(mid);
            int higher = a.get(high);
            if(middle > higher){
                if(target > middle || target <= higher)
                    low = mid + 1;
                else
                    high = mid;
            }else{
                if(target > middle && target <= higher)
                    low = mid + 1;
                else
                    high = mid;
            }
        }
        if(low == high && target != a.get(low))
            return -1;
        return low;
    }

    // recursive Search in rotated arr
    static int rotatedSearch(int[] a, int left, int right, int key){
        int mid = (left + right)/2;
        if(key == a[mid])
            return mid;

        if(right < left)
            return -1;

        /*
        Either the left or the right half must be ordered normally.
        Find out which side is normally ordered.
        Use the normally ordered half to figure out which side to search to find key.
        * */

        if(a[left] < a[mid]){  // left is ordered normally.
            if(key>=a[left] && key < a[mid])
                return rotatedSearch(a, left, mid-1, key); //search left
            else
                return rotatedSearch(a, mid+1, right, key); //search right
        }
        else if(a[mid] < a[left]){ // right is ordered normally.
            if(key > a[mid] && key <= a[right])
                return rotatedSearch(a, mid+1, right, key); //search right
            else
                return rotatedSearch(a, left, mid-1, key); //search left
        }
        else if(a[mid] == a[left]){ // left half or right half repeats
            if(a[mid] != a[right])   // if right is different search it
                return rotatedSearch(a, mid+1, right, key);  //search right
            else{ // search both halves
                int index = rotatedSearch(a, left, mid-1, key);  //search left
                if(index == -1)
                    return rotatedSearch(a, mid+1, right, key); //search right
                else
                    return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        //nums = [4,5,6,7,0,1,2], target = 7
        int[] a = {4,5,6,7,0,1,2};
        int key = 0;

        int n = a.length;

        //rotationIndex = 3;
        int index = search(a, key);
        System.out.println("Element "+key+" is found at "+index);

        key = 5;
        index = rotatedSearch(a, 0, n, key);
        System.out.println("Element "+key+" is found at "+index);
    }
}
