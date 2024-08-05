package array.math.two_pointers;

/*

sequence like

1.  x1 < x2 > x3 < x4 > x5. . . . . and so on
2.  x1 > x2 < x3 > x4 < x5. . . . . and so on

Input: arr= [1, 17, 5, 10, 13, 15, 10, 5, 16, 8]
Output: 7

Input: arr= [1, 5, 4]
Output: 3
* */

public class AlternatingMaxLength {

    public int alternatingMaxLengthGreedy(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        //2 pointers: up, down
        int up = 1;
        int down = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                up = down + 1;
            } else if (arr[i] < arr[i - 1]) {
                down = up + 1;
            }
        }

        return Math.max(up, down);
    }

    public static int alternatingMaxLength(int[] a) {
        int count = 1;
        int n = a.length;
        int i = 0;
        int j = 1;
        while(i<n && j<n){
            if(a[i] < a[j]){
                if(i>0 && ((j-i)==1))
                    count--;
                i=j;
                j++;
                if(a[i] > a[j]){
                    count+=3;
                }
            }
            i++;
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr= {1, 5, 4};
                //{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int x = alternatingMaxLength(arr);
        System.out.println(x);
    }
}
