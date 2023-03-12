package sort.gfg;

public class QuickLomuto {
    public static void main(String[] args) {

        int a[] = {100, 10, 5, 20, 80, 30, 70, 50, 15, 90, 40, 60, 9};

        int n = a.length;
        int low = 0;
        int high = n - 1;

        QuickLomuto lomuto = new QuickLomuto();
        lomuto.quickSortLomuto(a, low, high);

        System.out.println("quick sort with Lomuto's partitioning");

        for(int x : a){
            System.out.println(x);
        }
    }

    public void quickSortLomuto(int a[], int low, int high){
        if(low < high){
            int pivot = lomutoPartition(a, low, high);
            quickSortLomuto(a, low, pivot - 1);
            quickSortLomuto(a, pivot + 1, high);
        }
    }

    private int lomutoPartition(int a[], int low, int high){
        int pivot = a[high];   // ...(1)
        int i = low - 1;       // ... (2)      range  i -> a[i] < pivot
        for(int j =low; j < high-1; j++){
            if(a[j] < pivot){
                i++;

                //swap (a[i], a[j])  ...since (2)   ... j should be in range i

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }

            // swap (a[i+1], a[high])   ... put 'pivot' in correct position  ... since (1)

            int temp = a[i+1];        // ...(3)     ... (i+1) -> pivot's correct place
            a[i+1] = a[high];
            a[high] = temp;

            // swap x, y without temp

            /*
            x = x + y;
            y = x - y;
            x = x - y;

             */
        }
        return (i+1);   // since (3)
    }
}
