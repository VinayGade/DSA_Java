package recursion;

import java.util.Arrays;

// Leetcode 1313. Decompress Run-Length Encoded List
public class RunLengthEncodingDecompress {

    public static int[] decompressRLElist(int[] nums) {
        int size=nums.length;
        int n=0; //decompressed list length
        int k=0;
        while(k<size){
            n+=nums[k];
            k+=2;
        }
        int decompressed[]=new int[n];
        int j=0;
        for(int i=0; i<size; i+=2){
           /*
           int j=0;
           while(j<nums[i]){
               decompressed[i+j]=nums[i+1];
               j++;
           }*/
            Arrays.fill(decompressed, j, j + nums[i], nums[i + 1]);
            j += nums[i];
        }
        return decompressed;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        int[] decompressed = decompressRLElist(nums);

        System.out.println("input: ");
        for(int i=0; i< nums.length; i++){
            System.out.print(nums[i]+" ");
        }

        System.out.println("\noutput:");
        for(int i=0; i< decompressed.length; i++){
            System.out.print(decompressed[i]+" ");
        }
    }
}
