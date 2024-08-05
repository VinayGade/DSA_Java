package array.math.string;

//LeetCode 468: Validate IP Address

//IPv4 : x1.x2.x3.x4   ... 0 <= xi <= 255

//eg. 192.168.1.57

/*
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

public class ValidIPAddress {

    static boolean isValidIPv4(String ip){
        String[] tokens = ip.split("\\.", -1);

        if(tokens.length != 4)
            return false;

        for(String x: tokens){

            if(x.isEmpty() || x.length()>3)
                return false;

            if(x.charAt(0) == '0' && x.length() != 1)
                return false;

            for(char ch: x.toCharArray()){
                if(!Character.isDigit(ch))
                    return false;
            }

            if(Integer.parseInt(x) > 255)
                return false;
        }
        return true;
    }

    boolean isValidIPv6(String ip){
        String[] tokens = ip.split(":", -1);

        if(tokens.length != 8)
            return false;

        String hexDigits = "0123456789abcdefABCDEF";
        for(String x: tokens){
            if(x.isEmpty() || x.length()>4)
                return false;

            for(char ch: x.toCharArray()){
                if(hexDigits.indexOf(ch) == -1)
                    return false;
            }
        }
        return true;
    }

    public String validIPAddress(String queryIP) {

        String validIp = "";

        if(queryIP.contains("."))
            validIp = isValidIPv4(queryIP) ? "IPv4" : "Neither";
        else if(queryIP.contains(":"))
            validIp = isValidIPv6(queryIP) ? "IPv6" : "Neither";
        else validIp = "Neither";
        return validIp;
    }

    public static void main(String[] args) {
        String ip = "192.168.1.57";
        String validIP = isValidIPv4(ip) ? "IPv4" : "Invalid";
        System.out.println(validIP);
    }
}
