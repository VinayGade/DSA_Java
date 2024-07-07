package search.practice;

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

    public static void main(String[] args) {

        //nums = [4,5,6,7,0,1,2], target = 7
        int[] a = {4,5,6,7,0,1,2};
        int key = 0;

        //rotationIndex = 3;
        int index = search(a, key);
        System.out.println("Element "+key+" is found at "+index);
    }
}
