package sort.gfg;

public class QuickHorare{
    public static void main(String[] args) {

        int[] a = {100, 10, 5, 20, 80, 30, 70, 50, 15, 90, 40, 60, 9};

        int n = a.length;
        int low = 0;
        int high = n - 1;

        QuickHorare horare = new QuickHorare();
        horare.quickSortHorare(a, low, high);

        System.out.println("quick sort using Horare's Partitioning :");

        for(int i:a)
            System.out.println(i);
    }

    public void quickSortHorare(int a[], int low, int high){

        if(low < high){
            int pivot = horarePartition(a, low, high);
            quickSortHorare(a, low, pivot);
            quickSortHorare(a, pivot + 1, high);
        }
    }

    private int horarePartition(int a[], int low, int high){

        int pivot = a[low];
        int i = low - 1;
        int j = high + 1;

        while(true){

            do{
                i++;
            }while(a[i] < pivot);

            do{
                j--;
            }while(a[j] > pivot);

            if(i>=j)
                return j;

            // swap a[i], a[j]

            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
