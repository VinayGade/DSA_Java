package sort.gfg;

import sort.common.CommonUtility;

public class QuickSortCormen extends CommonUtility {

    public static void main(String[] args) {
        int a[] ={100, 10, 5, 20, 80, 30, 70, 50, 15, 90, 40, 1, 60, 9};

        QuickSortCormen quick = new QuickSortCormen();
        quick.quickSort(a, 0, a.length-1);

        System.out.println("after quick sort : \n");
        quick.display(a);
    }

    public void quickSort(int a[], int p, int r) {
        if(p < r) {
            int q = partition(a, p, r);
            quickSort(a, p, q-1);
            quickSort(a, q+1, r);
        }
    }

    public int partition(int a[], int p, int r) {

        int x= a[r];
        int i= p-1;

        for(int j=p; j<r; j++) {

            if(a[j] <= x) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a,i+1, r);
        return i+1;
    }
}