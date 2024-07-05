package array.math.matrix;

public class PalindromePattern {

    static String pattern(int[][] arr) {
        int n = arr.length;

        for(int i=0; i<n; i++){
            StringBuilder row = new StringBuilder();
            for(int j=0; j<n; j++){
                row.append(arr[i][j]);
            }
            if(isPalindrome(row.toString())){
                return i + " R";
            }
        }
        for(int j=0; j<n; j++){
            StringBuilder col = new StringBuilder();
            for(int i=0; i<n; i++){
                col.append(arr[i][j]);
            }
            if(isPalindrome(col.toString())){
                return j + " C";
            }
        }
        return "-1";
    }

    // 2-pointer
    static boolean isPalindrome(String str){
        int left = 0, right = str.length()-1;

        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 0, 0},
                {0, 1, 0},
                {1, 1, 0}};
        String result = pattern(arr);
        System.out.println(result);
    }
}
