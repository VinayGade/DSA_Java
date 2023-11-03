package search.practice;

public class Median {

    /*
    Input:
    m = 3, n = 4
    array1[] = {1,5,9}
    array2[] = {2,3,6,7}
    Output: 5
    Explanation: The middle element for
    {1,2,3,5,6,7,9} is 5

    m = 2, n = 4
    array1[] = {4,6}
    array2[] = {1,2,3,5}
    Output: 3.5
    * */

    // merge function of merge sort
    static double medianOfArrays(int n, int m, int a[], int b[]) {
        int size = n+m;
        int[] c = new int[size];
        int x = Math.max(n, m);
        int mid = size/2;
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<m && j<n){
            if(a[i]<=b[j]){
                c[k]=a[i];
                i++;
            }else{
                c[k]=b[j];
                j++;
            }
            k++;
        }
        while(i<m){
            c[k]=a[i];
            i++;
            k++;
        }
        while(j<n){
            c[k]=b[j];
            j++;
            k++;
        }
        return (size%2==0) ? (double)(c[mid]+c[mid-1])/2 : c[mid];
    }

    public static void main(String[] args) {

        int  m = 3, n = 4;
        int[] array1 = {1,5,9};
        int[] array2 = {2,3,6,7};

        double median = medianOfArrays(n, m, array1, array2);

        m = 2;
        int[] a = {4,6};
        int[] b = {1,2,3,5};

        double median2 = medianOfArrays(n, m, a, b);

        System.out.println("median = "+median+", median2 = "+median2);

    }
}
