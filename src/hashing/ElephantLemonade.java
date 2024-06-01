package hashing;

import java.util.*;

// Little Elephant and Lemonade

/*

Little Elephant likes lemonade.

When Little Elephant visits any room, he finds the bottle of the lemonade in
that room that contains the greatest number of litres of lemonade and drinks it all.

There are n rooms (numbered from 0 to n-1), each contains Ci bottles. Each bottle
has a volume (in litres). The first room visited by Little Elephant was P0-th,
the second - P1-th, ..., the m-th - Pm-1-th room. Note that Little Elephant
may visit a room more than once.

Find for Little Elephant the total volume of lemonade he has drunk.

Input
First line of the input contains single integer T - the number of test cases.
T test cases follow. First line of each test case contains pair of integers n and m.
Second line contains m integers separated by a single space - array P.
Next n lines describe bottles in each room in such format:
Ci V0 V1 ... VCi-1, where V is the list of volumes (in liters) of all bottles in i-th room.

Output
In T lines print T integers - the answers for the corresponding test cases.

Constraints
1 <= T <= 10

1 <= n, Ci <= 100

1 <= m <= 10^4

0 <= Pi < n

1 <= Vi <= 10^5

Input
2
3 3
0 2 1
3 1 2 3
1 7
2 4 7
4 7
0 1 3 0 1 0 0
1 7
3 9 4 5
7 1 2 3 4 5 6 7
1 1

Output
17
22
* */

public class ElephantLemonade {

    public static void main2 (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0){
            int n = scan.nextInt();
            int m = scan.nextInt();
            int[] visitedRooms = new int[m];
            for(int i=0; i<m; i++)
                visitedRooms[i] = scan.nextInt();

            for(int i=0; i<n; i++){
                Integer[] bottles = new Integer[scan.nextInt()];
                for(int j=0; j<bottles.length; j++)
                    bottles[j] = scan.nextInt();
                int amountOfLemonadeDrunk = findDrunkLemonade(visitedRooms, bottles, n);
            }
            //System.out.println(amountOfLemonadeD
        }
    }

    static int findDrunkLemonade(int[] visitedRooms, Integer[] bottles, int n){

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer[]> bottlesList = new ArrayList<>();

        Arrays.sort(bottles, Collections.reverseOrder());
        bottlesList.add(bottles);

        for(int i=0;i<n;i++)
            map.put(i, 0);

        int amount = 0;
        for(int i=0; i<visitedRooms.length; i++){
            int index = map.get(visitedRooms[i]);
            if(index <= bottlesList.get(visitedRooms[i]).length -1) {
                amount += bottlesList.get(visitedRooms[i])[index];
            }
            map.put(visitedRooms[i], map.get(visitedRooms[i]) + 1);
        }
        return amount;
    }

    // Optimized code
    // correct solution using ArrayList.
    static int findDrunkLemonadeAmount(int m, int[] path, List<List<Integer>> rooms){
        int amount=0;
        for(int i=0;i<m;i++){
            //if(room.get(path[i]).isEmpty()!=true){
            if(!rooms.get(path[i]).isEmpty()){
                amount=amount+rooms.get(path[i]).get(rooms.get(path[i]).size()-1);
                rooms.get(path[i]).remove(rooms.get(path[i]).size()-1);
            }
        }
        return amount;
    }

    public static void main (String[] args) throws java.lang.Exception{

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int p=0;p<t;p++){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[] path=new int[m];
            for(int i=0;i<m;i++){
                path[i]=sc.nextInt();
            }
            List<List<Integer>> rooms=new LinkedList<>();
            for(int i=0;i<n;i++){
                List<Integer> temp=new LinkedList<>();
                int l=sc.nextInt();
                for(int j=0;j<l;j++){
                    temp.add(sc.nextInt());
                }
                Collections.sort(temp);
                rooms.add(temp);
            }
            int amount = findDrunkLemonadeAmount(m, path, rooms);
            System.out.println(amount);
        }

    }
}
