package recursion;

public class CountCharOccurence {

    public int[] charFrequency( String str){

        int i=0;
        int length = str.length();
        int [] counter = new int[256];

        while(i < length){

            counter[(int) str.charAt(i)]++;
            i++;
        }
        return counter;
    }

    public void displayCharFrequency( int[] counter){
        for( int j=0; j<counter.length; j++){
            if(counter[j] != 0)
                System.out.println("[ "+(char)j+"] = "+counter[j]);
        }

    }

    public static void main(String[] args) {
        String str = "Java SE 8 Lambda Expression";

        CountCharOccurence freq = new CountCharOccurence();

        int[] frequency = freq.charFrequency(str);

        freq.displayCharFrequency(frequency);
    }


}
