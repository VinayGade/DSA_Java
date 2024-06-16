package hashing;

import java.util.LinkedHashMap;
import java.util.Map;

/*
GeeksForGeeks: POTD

Given a set of n nuts & bolts. There is a one-on-one mapping between nuts and bolts.
You have to Match nuts and bolts efficiently.
Comparison of a nut to another nut or a bolt to another bolt is not allowed.
It means the nut can only be compared with the bolt and the bolt can only be compared
with the nut to see which one is bigger/smaller.

The elements should follow the following order: { !,#,$,%,&,*,?,@,^ }
* */
public class NutsAndBolts {

    public static void main(String[] args) {
        /*
        n = 9, nuts[] = {^, &, %, @, #, *, $, ?, !},
        bolts[] = {?, #, @, %, &, *, $ ,^, !}
        * */
        int n = 9;
        char [] nuts = {'^', '&', '%', '@', '#', '*', '$', '?', '!'};
        char [] bolts = {'?', '#', '@', '%', '&', '*', '$', '^', '!'};
        matchPairs(n, nuts, bolts);
    }

    static void matchPairs(int n, char nuts[], char bolts[]) {
        Map<Character, Integer> orderMap = ordering();
        int MAX = 9;
        char[] nutsBolts = new char[MAX];
        /*
        char[] sortedNuts= new char[n];
        char[] sortedBolts= new char[n];
        */
        int i=0;
        for(Map.Entry<Character, Integer> entry: orderMap.entrySet()){
            //if(i>=n || i>=MAX)
            if(i>=n)
                break;
            char key = nuts[i];
            int index = orderMap.get(key);
            nutsBolts[index] = key;
            i++;
        }
        int k=0;  //upto
        for(int j=0; j<MAX; j++){
            if(nutsBolts[j]!='\u0000' && k<n){
                //System.out.print(nutsBolts[j]+" ");
                nuts[k] = nutsBolts[j];
                bolts[k]= nutsBolts[j];
                k++;
            }
        }
        //System.out.print(nutsBolts[n-1];

        for(int t=0; t<n; t++)
            System.out.print(nuts[t]+" ");

        System.out.println();
        for(int u=0; u<n; u++)
            System.out.print(bolts[u]+" ");

    }

    static Map<Character, Integer> ordering(){
        char[] order = { '!','#','$','%','&','*','?','@','^' };

        Map<Character, Integer> orderMap = new LinkedHashMap<>();

        for(int i=0; i<order.length; i++)
            orderMap.put(order[i], i);

        return orderMap;
    }
}
