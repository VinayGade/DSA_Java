package backtracking;

import java.util.HashMap;
import java.util.Map;

/*
Mobile numeric keypad:

There is a standard numeric keypad on a mobile phone.
You can press the current button or any button that is directly above, below, to the left,
 or to the right of it.
 For example, if you press 5, then pressing 2, 4, 6, or 8 is allowed.
 However, diagonal movements and pressing the bottom row corner buttons (* and #)
 are not allowed.
Input: n = 1
Output: 10
Explanation: Possible 1-digit numbers follow keypad moves -
From 0 → 0, 1 → 1, 2 → 2 and so on, total 10 valid combinations are possible.

Input: n = 2
Output: 36
Explanation: Possible 2-digit numbers follow keypad moves -
From 0 → 00, 08 (2),
From 1 → 11, 12, 14 (3),
From 3 → 33, 32, 36 (3), and so on,
total 36 valid combinations are possible.
* */

public class MobileNumericKeyPad {

    public static int getCount(int n) {
        // code here
        int dialPad[][]=new int[][]{{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
        int ans=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                ans+=rec(i,j,dialPad,n, new HashMap<>());
            }
        }
        return ans;
    }

    private static int rec(int i,int j,int dial[][],int n, Map<String,Integer> hm){
        if(i<0 || j<0 || i==4 || j==3 || dial[i][j]==-1)
            return 0;

        String key=i+" "+j+" "+n;

        if(hm.containsKey(key))
            return hm.get(key);

        int curr=0;
        if(n==1)
            return 1;

        curr+=rec(i,j,dial,n-1,hm);
        curr+=rec(i-1,j,dial,n-1,hm);
        curr+=rec(i+1,j,dial,n-1,hm);
        curr+=rec(i,j+1,dial,n-1,hm);
        curr+=rec(i,j-1,dial,n-1,hm);
        hm.put(key,curr);
        return curr;
    }

    public static void main(String[] args) {
        int n = 2;
        int count = getCount(n);
        System.out.println(count);
    }
}
