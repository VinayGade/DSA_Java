package array.math.two_pointers;

// LeetCode 3206. Alternating Groups I

/*
There is a circle of red and blue tiles. You are given an array of integers colors.
The color of tile i is represented by colors[i]:

colors[i] == 0 means that tile i is red.
colors[i] == 1 means that tile i is blue.

Every 3 contiguous tiles in the circle with alternating colors
(the middle tile has a different color from its left and right tiles)
is called an alternating group.

Return the number of alternating groups.

Note: since colors represents a circle, the first and the last tiles are considered to be
next to each other.

3 <= colors.length <= 100
0 <= colors[i] <= 1

Input: colors = [1,1,1]

Output: 0

Input: colors = [0,1,0,0,1]

Output: 3
* */
public class AlternatingGroups {

    static int numberOfAlternatingGroups(int[] colors) {
        /*
        0 = Red
        1 = Blue
        middle is different from left and right tiles
        first != last
        alternating group.
        */
        int n = colors.length;

        //3-pointer approach
        int j=1;
        int k=2;
        int count =0;

        for(int i=0; i<n-2; i++){
            if(colors[i] != colors[j] && colors[j] != colors[k])
                count++;
            j++;
            k++;
        }
        if(n>=3){
            if(colors[n-2] != colors[n-1] && colors[n-1] != colors[0])
                count++;
            if(colors[n-1] != colors[0] && colors[0]!=colors[1])
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] colors = {0,1,0,0,1};
        int count = numberOfAlternatingGroups(colors);
        System.out.println(count);
    }
}
