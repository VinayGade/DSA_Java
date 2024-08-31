package hashing;

import java.util.*;

// CodeChef: Malvika is peculiar about color of balloons

/*
Little Malvika is very peculiar about colors.
On her birthday, her mom wanted to buy balloons for decorating the house.
So she asked her about her color preferences. The sophisticated little person that Malvika is,
 she likes only two colors — amber and brass.
Her mom bought n balloons, each of which was either amber or brass in color.
 You are provided this information in a string s consisting of characters 'a' and 'b' only,
 where 'a' denotes that the balloon is amber, where 'b' denotes it being brass colored.

Input:
3
ab
bb
baaba

Output:
1
0
2
* */

public class BalloonColors {

    static int countFlips(String s){
        int i = 0;
        Map<Character, Integer> charFrequency = characterFrequency(s);
        Collection<Integer> frequencies = charFrequency.values();
        if(frequencies.size() == 1)
            return 0;
        Iterator<Integer> iter = frequencies.iterator();
        int min = Integer.MAX_VALUE;
        while(iter.hasNext()){
            min = Math.min(min, iter.next());
        }
        return min;
    }

    public static Map<Character, Integer> characterFrequency(String string){

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(char c: string.toCharArray())
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
        return frequencyMap;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            String input = scanner.next();

            //count minimum number of baloons to be colored
            int count = countFlips(input);

            System.out.println(count);
        }
    }
}
