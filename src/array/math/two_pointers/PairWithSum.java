package array.math.two_pointers;

public class PairWithSum {

    static int countPairs(int arr[], int target) {

        int count = 0;
        int high = arr.length - 1;
        int low = 0;
        /*
        int first = arr[0];
        int seond = arr[high];
        */
        while(low < high){
            if(arr[low] + arr[high] == target) {
                if(arr[low] == arr[high]){
                    int n = high - low + 1;
                    count += (n * (n-1)) / 2;
                    return count;
                }else{
                    int c1 = 1, c2 = 1;
                    while((low+1) < high && arr[low+1] == arr[low]){
                        low++;
                        c1++;
                    }
                    while((high-1) > low && arr[high-1] == arr[high]) {
                        high--;
                        c2++;
                    }
                    count += c1 * c2;
                    low++;
                    high--;
                }
            }else if((arr[low] + arr[high]) < target)
                low++;
            else
                high--;
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {-1, 1, 5, 5, 7};  // arr[] = [-1, 10, 10, 12, 15]
        int target = 6;
        int count = countPairs(arr, target);
        System.out.println(count);
    }
}
