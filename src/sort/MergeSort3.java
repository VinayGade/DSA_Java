package sort;

import sort.common.CommonUtility;

public class MergeSort3 extends CommonUtility {

    public static void main(String[] args) {

        int[] arr = {500, 100, 25, 50, 20, 15, 200, 30, 10, 40, 70, 80, 300, 150, 65, 5, 2, 1};

        CommonUtility sort = new MergeSort3();

        System.out.println(" * * * * * Before Merge Sort * * * * *");
        sort.display(arr);

        mergeSort(arr, 0, arr.length-1);

        System.out.println("\n * * * * * After Merge Sort * * * * *");
        sort.display(arr);
    }

    static void simpleMerge(int[] a, int f, int s, int t) {

        int i, j, k, w;
        int temp[] = new int[a.length];

        i = f;
        j = s;
        k = -1;

        while (i <= s - 1 && j <= t) {
            if (a[i] < a[j]) {
                k++;
                temp[k] = a[i];
                i++;
            } else {
                k++;
                temp[k] = a[j];
                j++;
            }
        }

        // copy remaining elements in temp array
        if (i > s - 1) {
            for (w=j; w<=t; w++) {
                k++;
                temp[k] = a[w];
            }
        } else {
            for (w=i; w<=s - 1; w++) {
                k++;
                temp[k] = a[w];
            }
        }

        //copy temp into array a
        for(w=0; w<=k; w++)
            a[f+w] = temp[w];
    }

    static void mergeSort(int a[], int left, int right){
        if(left < right) {  // a.length >= 2
            int mid = (left + right) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid+1, right);
            simpleMerge(a, left, mid, right);
        }
    }
}