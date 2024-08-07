package sort.merge;

public class KthElementOf2Arr {

    public static long kthElement(int k, int arr1[], int arr2[]) {

        // Merge 2 sorted arrays

        int m = arr1.length;
        int p = arr2.length;

        int n = m + p;

        int[] A = new int[n];
        long element = -1;

        int i = 0;
        int j = 0;

        int x = 0;

        while(i < m && j < p){

            if(arr1[i] < arr2[j]){
                A[x] = arr1[i];
                i++;
                x++;
            }else{
                A[x] = arr2[j];
                j++;
                x++;
            }
        }

        while(i < m){
            A[x] = arr1[i];
            i++;
            x++;
        }

        while(j < p){
            A[x] = arr2[j];
            j++;
            x++;
        }

        for(int index = 0; index < n; index++){
            if(index == (k-1)){
                element = A[index];
                break;
            }
        }
        return element;
    }

    public static void main(String[] args) {
        int k = 5;
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};

        long key = kthElement(k, arr1, arr2);
        System.out.println(key);
    }
}
