    package recursion;

    public class SumOfDigits {
            // complete the function
            public static int sumOfDigits(int n) {
                int sum = 0;
                int temp = n;
                while(temp > 0){
                    sum = sum + temp%10;
                    temp /= 10;
                }
                return sum;
            }

            public static int sumOfDigitsRecursive(int n) {

                if (n == 0)
                    return 0;
                return (n % 10 + sumOfDigitsRecursive(n / 10));
            }

            public static void main(String[] args) {

                int number = 12356;
                System.out.println("sum of digits of "+number+" is "+sumOfDigits(number));
                System.out.println("sum of digits of "+number+" using recursion is "+sumOfDigits(number));
            }

    }
