package array.math.two_pointers;

public class PeakValleys {

    //Peaks and Valleys:

    // Sort an array into alternating sequence of peaks and valleys.

    //Note: This problem is replica of ZigZagArray.

    static int[] peaksValleys(int[] A, int N){
        int base = A[0];
        boolean peak = true;
        for(int i=0; i<(N-1); i++){
            if(peak){
                if(A[i] > A[i+1]) {
                    //swap A[i] , A[i+1]
                    swap(A, i, i + 1);
                    //peak = !peak; // peak -> valley.   ...After Peak there should be a valley
                }
            }
            else{
                if(A[i] < A[i+1]) {
                    //swap A[i] , A[i+1]
                    swap(A, i, i + 1);
                    //peak = !peak; // valley -> peak.   ...After valley there should be a Peak
                }
            }
            peak = !peak;
        }
        return A;
    }

    static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int a[] = {5, 8, 6, 2, 3, 4, 6};
        int n = a.length;
        int[] peakValleys = peaksValleys(a, n);
        for(int x: peakValleys)
            System.out.print(x+" ");
    }
}
