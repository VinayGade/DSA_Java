package hashing;

import java.util.HashMap;
import java.util.Map;

/*
LC 454: 4Sum II

 arrays: nums1, nums2, nums3, nums4 ...all of length = n

nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0   ...0 <= i, j, k, l < n
* */
public class FourSum2 {

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int c: C){
            for(int d: D)
                map.put((c+d), map.getOrDefault((c+d), 0) + 1);
        }
        int count = 0;
        for(int a: A){
            for(int b: B)
                count += map.getOrDefault(-(a+b), 0);
        }
        return count;
    }

    public static void main(String[] args) {

        int[] A= {1,2};
        int[] B= {-2,-1};
        int[] C= {-1,2};
        int[] D= {0,2};

        int count = fourSumCount(A, B, C, D);
        System.out.println("count = "+count);
    }
}
