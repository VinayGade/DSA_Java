package array.math.two_pointers;

//Convert array into Zig-Zag fashion

//import java.util.Arrays;

/*

Input: n = 7, arr[] = {4, 3, 7, 8, 6, 2, 1}
Output: 3 7 4 8 2 6 1
Explanation: 3 < 7 > 4 < 8 > 2 < 6 > 1

Input: n = 4, arr[] = {1, 4, 3, 2}
Output: 1 4 2 3
Explanation: 1 < 4 > 2 < 3

* */
public class ZigZagArray {

    public static void zigZag(int n, int[] arr) {
        // i= 0, 2, 4, ...    smaller elements (for even index)
        boolean flag = true;

        for(int i = 0; i < (n - 1); i++) {
            if(flag) {
                if(arr[i] > arr[i + 1])
                    swap(i, i + 1, arr);
            } else {
                if(arr[i] < arr[i + 1])
                    swap(i, i + 1, arr);
            }
            flag = !flag;
        }
    }

    static void swap(int i, int j, int []arr) {

        //your code here
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int n = 7;
        int a[] = {4, 3, 7, 8, 6, 2, 1};
        zigZag(n, a);
        for(int x: a){
            System.out.print(x+" ");
        }
        //Arrays.stream(a).forEach(System.out::print);
    }
}
