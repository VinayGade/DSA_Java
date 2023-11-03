package array.math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public enum RomanSymbol{

        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        private int value;

        RomanSymbol(int value){
            this.value=value;
        }
    }

    public static int romanToInt(String s) {

        int number = 0;
        int n = s.length();
        for(int i=n-1; i>=0; i--){
            char c=s.charAt(i);
            char next=(i<n-1) ? s.charAt(i+1) : '-';
            RomanSymbol symbol = RomanSymbol.valueOf(String.valueOf(s.charAt(i)));
            //RomanSymbol nextSymbol = RomanSymbol.valueOf(String.valueOf(s.charAt(i+1)));
            switch(symbol){
                case I:
                    int decimal1 = RomanSymbol.I.value;
                    if(i<n-1 && c!=next)
                        number-=decimal1;
                    else
                        number+=decimal1;
                    continue;

                case V:
                    number+=RomanSymbol.V.value;
                    continue;

                case X:
                    int decimal10 = RomanSymbol.X.value;
                    if(i<n-1 && (next == 'L' || next == 'C')) //c!=next
                        number-=decimal10;
                    number+=decimal10;
                    continue;

                case L:
                    number+=RomanSymbol.L.value;
                    continue;

                case C:
                    int decimal100 = RomanSymbol.C.value;
                    if(i<n-1 && (next == 'D' || next == 'M')) //c!=next
                        number-=decimal100;
                    number+=decimal100;
                    continue;

                case D:
                    number+=RomanSymbol.D.value;
                    continue;

                case M:
                    number+=RomanSymbol.M.value;
                    continue;

                default:
                    break;
            }
        }
        return number;
    }

    public int romanToInteger(String s) {
        int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }

    public int romanToIntHash(String s) {

        Map<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        for(int i = 0; i < s.length()-1; i++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1)))
                res -= map.get(s.charAt(i));
            else
                res += map.get(s.charAt(i));
        }
        return res + map.get(s.charAt(s.length()-1));
    }

    public static int romanToIntBest(String s) {

        int num = 0;
        int l = s.length();
        int last = 1000;
        for (int i = 0; i < l; i++){
            int v = getValue(s.charAt(i));
            if (v > last) num = num - last * 2;
            num = num + v;
            last = v;
        }
        return num;
    }

    private static int getValue(char c){
        switch(c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }

    public static void main(String[] args) {

        // "VIII" , "IV", "V", "X", "III", "II", "I", "VII", "VI", "IX"
        String roman = "XXIV"; // MCMXCIV  LVIII
        int number = romanToIntBest(roman);
        System.out.println("Roman = "+roman+" Int = "+number);
    }
}
