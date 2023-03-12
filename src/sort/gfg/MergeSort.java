package sort.gfg;

public class MergeSort {

    public void mergeSort(int a[], int low, int high){

        if(low < high) {  // a.length >= 2
            int mid = low + (high - low) / 2;

            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);
            merge(a, low, mid, high);
        }
    }

    private void merge(int a[], int low, int mid, int high){

        int[] c = new int[a.length];
        int i = low;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= high){

            if(a[i] <= a[j]) {
                c[k] = a[i];
                i++;
            }else {
                c[k] = a[j];
                j++;
            }
            k++;
        }

        while(i <= mid){
            c[k] = a[i];
            i++;
            k++;
        }

        while(j <= high){
            c[k] = a[j];
            j++;
            k++;
        }

        for( i=low, j=0; i<=high; i++, j++)
            a[i]=c[j];
    }

    public static void main(String[] args) {

        MergeSort sort = new MergeSort();

        int a[] = {100, 10, 5, 20, 80, 30, 70, 50, 15, 90, 40, 60, 9};

        int n = a.length;
        int low = 0;
        int high = n - 1;
        int mid = low + (high - low)/2;

        System.out.println("array size n ="+n);
        System.out.println("low ="+low);
        System.out.println("high ="+high);
        System.out.println("mid ="+mid);

        sort.mergeSort(a, low, high);

        System.out.println("Sorted Array:");

        for (int j : a)
            System.out.println(j);

    }
}
