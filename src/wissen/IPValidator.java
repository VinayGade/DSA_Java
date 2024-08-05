package wissen;

//LeetCode 468: Valid IP address (IPv4 or IPv6)

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
IPv4:
Given a string queryIP, return "IPv4" if IP is a valid IPv4 address,

IPv6:
"IPv6" if IP is a valid IPv6 address or

"Neither" if IP is not a correct IP of any type.

IPv4:
A valid IPv4 address is an IP in the form "x1.x2.x3.x4"
where 0 <= xi <= 255 and xi cannot contain leading zeros.
eg. "192.168.1.1",  "192.168.1.0"   -> valid ip address

"192.168.01.1", "192.168.1.00", "192.168@1.1  -> invalid IPv4 address

IPv6:
x1:x2:x3:x4:x5:x6:x7:x8

1 <= xi.length <= 4

xi is a hexadecimal string which may contain digits,
lowercase English letter ('a' to 'f') and upper-case English letters ('A' to 'F').

Leading zeros are allowed in xi.

For example,
"2001:0db8:85a3:0000:0000:8a2e:0370:7334", "2001:db8:85a3:0:0:8A2E:0370:7334" -> valid IPv6
"2001:0db8:85a3::8A2E:037j:7334", "02001:0db8:85a3:0000:0000:8a2e:0370:7334" -> invalid IPv6


Example 1:

Input: queryIP = "172.16.254.1"
Output: "IPv4"
Explanation: This is a valid IPv4 address, return "IPv4".
Example 2:

Input: queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
Output: "IPv6"
Explanation: This is a valid IPv6 address, return "IPv6".
Example 3:

Input: queryIP = "256.256.256.256"
Output: "Neither"
Explanation: This is neither a IPv4 address nor a IPv6 address.

* */
public class IPValidator {

    //valid ip address
    //128.32.217.54  ... 3 . and 12 digits

    static boolean isValid(String ip){
        int n = ip.length();
        if(!ip.contains(".") || n>15)
            return false;

        int size = 4;
        String[] tokens = ip.split(".");
        if(tokens.length != 4)
            return false;
        for(int i=0; i<size; i++){

            char[] digits = tokens[i].toCharArray(); // size = 3
            if(digits.length > 3)
                return false;
            else{
                for(int j=0; j<3; j++){
                    if(digits[i] < '0' || digits[i] > '9')
                        return false;
                }
            }

            int token = Integer.parseInt(tokens[i]);
            if (token >= 256)
                return false;

        }
        return true;
    }

    public static void main(String[] args) {
        String ip = "128.32.217.54";
        boolean valid = isValid(ip);
        System.out.println(valid);

        //Solution solution = new Solution();

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        Pattern[] ipPatterns = obtainIpPatterns();

        while (t-- > 0) {
            String input = scanner.next();
            String result = validateIp(input, ipPatterns);
            System.out.println(result);
        }
    }

    //Regular Expression: using java.util.regex

    /*
    Subpatterns :
     0 - 199
     200 - 249
     250 - 255
    * */

    /*
---------- v = "[a-fA-F0-9]{1,4}" ---------------
4 hexadecimal digits.
Hexadecimal means either using a-f or 0-9
ff translates to 00ff. So no of digits can be either 1,2,3 or 4. So use {1,4}

---------- u = "(25[0-5]|2[0-4]\\d|1?\\d?\\d)" ---------------
Means 0 to 255
3 digit combinations:
    25[0-5]  or 2[0-4][0-9] or 1[0-9][0-9]
2 digit combinations:
    [0-9][0-9]
1 digit combinations:
    [0-9]
Combining 1 digit and 2 digit combinations: becomes: [0-9]?[0-9]
    Combine this with 1[0-9][0-9] : becomes : 1?[0-9]?[0-9]
So final set of combinations : becomes:
    25[0-5]  or 2[0-4][0-9] or 1?[0-9]?[0-9]


*/

    static Pattern[] obtainIpPatterns(){
        /*
        String regex = "([01]?\\d{1,2}|2[0-4]\\d|25[0-5])";
        String pattern = regex + "." + regex + "." + regex + "." + regex;
        */
        String u = "(25[0-5]|2[0-4]\\d|1?\\d?\\d)"; //0 to 255
        String regex_ipv4 = String.format("^(%s\\.){3}%s$",u,u); //u.u.u.u
        String v = "[a-fA-F0-9]{1,4}"; //4 hexadecimal digits
        String regex_ipv6 = String.format("^(%s\\:){7}%s$",v,v);
        Pattern pattern_ipv4 = Pattern.compile(regex_ipv4);
        Pattern pattern_ipv6 = Pattern.compile(regex_ipv6);
        return new Pattern[]{pattern_ipv4, pattern_ipv6};
    }

    static String validateIp(String ip, Pattern[] ipPatterns){

        Pattern pattern_ipv4 = ipPatterns[0];
        Pattern pattern_ipv6 = ipPatterns[1];
        Matcher matcher_ipv4 = pattern_ipv4.matcher(ip);
        Matcher matcher_ipv6 = pattern_ipv6.matcher(ip);
        if (matcher_ipv4.find())
            return "IPv4";
        else if (matcher_ipv6.find())
            return "IPv6";
        else
            return "Neither";
    }

}
