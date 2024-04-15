package sort;

public class ReverseVowelsOfString {

    public static String reverseVowels(String s){
        char[] str = s.toCharArray();
        int start =0;
        int end = str.length-1;
        while(start<end){
            if(!isVowel(str[start]))
                start++;
            if(!isVowel(str[end]))
                end--;
            else{
                //swap str(start, end)

                char temp=str[start];
                str[start]=str[end];
                str[end]=temp;
                start++;
                end--;
            }
        }
        return String.valueOf(str);
    }

    private static boolean isVowel(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    public static void main(String[] args) {
        String s = "hello";
        String reverse = reverseVowels(s);
        System.out.println(reverse);
    }
}
