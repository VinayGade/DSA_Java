package search.practice;

// Find Majority element in array
/*
most frequent element if frequency >= 2
element that appears strictly more than N/2 times in the array.
eg.
N = 5
A[] = {3,1,3,3,2}
majority = 3

N = 3
A[] = {1,2,3}
majority = -1

N = 10
A[] = {3,2,3,5,5,9,1,5,3,5}
majority = 5
* */
public class MajorityElement {

    /* Function to find the candidate for Majority */
    static int findCandidate(int a[], int size) {
        int maj_index = 0, count = 1;
        // use linear search to compute candidate for majority element
        for (int i = 1; i < size; i++) {
            if (a[maj_index] == a[i])
                count++;
            else
                count--;
            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }
    // Function to check if the candidate occurs more than n/2 times
    static boolean isMajority(int a[], int size, int cand) {
        int count = 0;
        for (int i = 0; i < size; i++)
            if (a[i] == cand)
                count++;
        return count > (size / 2);
    }
    static int majorityElement(int a[], int size){
        /* Find the candidate for Majority*/
        int cand = findCandidate(a, size);

        /* Print the candidate if it is Majority*/
        return (isMajority(a, size, cand)) ? cand : -1;
    }

    public static void main(String[] args) {

        int n = 10;
        int[] a = {3,2,3,5,5,9,1,5,3,5};
        int majority = majorityElement(a, n);
        System.out.println("Majority ="+majority);
    }
}
