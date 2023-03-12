package sort;

public class CommonUtility {

    public void display(int[] array){
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public int[] swap(int[] array, int x, int  y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
        return array;
    }
}
