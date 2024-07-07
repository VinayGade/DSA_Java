package array.math.two_pointers;

import java.util.ArrayList;
import java.util.List;

public class AlternatingGroups2 {

    //Dynamic Programming
    static int numberOfAlternatingGroups(int[] colors, int k) {
        int ans = 0 , dp = 0;
        List<Integer> colorList = new ArrayList<>();
        //Initialization
        for (int color : colors) {
            colorList.add(color);
        }
        for (int color : colors) {
            colorList.add(color);
        }
        for (int i = 0; i - k + 1 < colors.length; i++) {
            if (i == 0) {
                dp = 1;
            } else {
                //If alternate increase size
                if (colorList.get(i) != colorList.get(i - 1)) {
                    dp ++;
                }
                //Else reset the size
                else {
                    dp = 1;
                }
            }
            //Condition check for length=k
            if (i >= k - 1) {
                if (dp >= k) {
                    ans ++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] colors = {0,1,0,0,1,0,1};
        int k = 6;
        int result = numberOfAlternatingGroups(colors, k);
        System.out.println(colors);
    }
}
