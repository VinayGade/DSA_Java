package recursion;

public class FirstLastOccurance {

    static int first, last = -1;

    public int[] occurance(String str, int index, char key){
        if(index == str.length()){
            int[] firstLastIndex= new int[2];
            firstLastIndex[0]=first;
            firstLastIndex[1]=last;
            return firstLastIndex;
        }else {
            char current = str.charAt(index);
            if (current == key) {
                if (first == -1)
                    first = current;
                else
                    last = current;
            }
            return occurance(str, index + 1, key);
        }
    }


    // iterative 2 pointer approach: firstIndex and lastIndex
    public int[] firstLastIndex(String str, char key){
        int firstI = -1;
        int lastI = -1;  // initialize first and last index

        int n = str.length();

        int i = 0;
        while(i < n){
            if(str.charAt(i) == key){
                firstI = i;
                lastI = i;
                break;
            }
            i++;
        }

        int j = n-1;
        while(j > i){
            if(str.charAt(j) == key){
                lastI = j;
                break;
            }
            j--;
        }

        int[] solution = {firstI, lastI};
        return solution;
    }

    public static void main(String[] args) {
        String src = "abracadabra";

        char key = 'b';

        FirstLastOccurance firstLastOccurance = new FirstLastOccurance();

        int[] solution = firstLastOccurance.occurance(src, 0, key);

        System.out.println("start ="+solution[0] + ", end ="+solution[1]);

        System.out.println("First and last index using 2 pointer approach :");

        int[] indices =firstLastOccurance.firstLastIndex(src, key);

        System.out.println("First and last index of "+key+" in string :"+src+" : ");
        System.out.println("First occurence ("+key+ ")="+indices[0]);
        System.out.println("Last occurence ("+key+ ")="+indices[1]);
    }
}
