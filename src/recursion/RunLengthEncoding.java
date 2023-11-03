package recursion;

public class RunLengthEncoding {

    /*
    input = "aabbbccdddddaeeee"
    output = "2a3b2c5d4e"

    input = "abcd"
    output = "1a1b1c1d"

    * */

    public static String runLengthEncoding(String string){

        if(string.length() < 2)
            return "1"+string;
        char[] original = string.toCharArray();
        String encoded = "";
        int count = 1;
        int prev = 0;
        for(int i=1; i<original.length; i++){
            if(original[prev] == original[i])
                count++;
            else{
                encoded+=count+""+original[prev];
                count=1;
            }
            prev++;
        }
        return encoded;
    }

    public static void main(String[] args) {
        String input1 = "aabbbccdddddaeeee";
        String input2 = "abcd";

        String encoded1 = runLengthEncoding(input1);
        String encoded2 = runLengthEncoding(input2);

        System.out.println("input1 = "+input1+" --> encoded1 = "+encoded1);
        System.out.println("input2 = "+input2+" --> encoded2 = "+encoded2);
    }
}
