package recursion;

public class ReverseString {

    public void reverse(char[] c, int l, int h){
        if( l < h ){
            swap(c, l, h);
            reverse(c, l+1, h-1);
        }
    }

    private void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    private void reverseIterative(char[] c){
        int n = c.length;
        int i = 0;
        int j = n - 1;
        while( i<n && j>=0 ){
            swap(c, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {

        String source = "Java SE 8 Stream API";

        ReverseString reverseString = new ReverseString();

        char[] c = source.toCharArray();
        reverseString.reverse(c, 0, c.length - 1);
        String reverse = new String(c);

        System.out.print("Reverse of the given string : "+source+" = " +reverse);
    }

}