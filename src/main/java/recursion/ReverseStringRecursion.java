package recursion;

public class ReverseStringRecursion {

    public static void main(String[] args) {
        String s = "apple";
        System.out.println(reverse(s));

        String a = "ABCBA";
        System.out.println(isPalindrome(a));


        int n = 8;
        System.out.printf("fibo %d : %d ", n, fibo(n) );

    }


    private static String reverse(String str) {
        if (str.length() == 1) {
            return str;
        }
        return "" + str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
    }

    private static boolean isPalindrome(String str) {
        if (str.length() == 1 || str.length() ==0) {
            return true;
        }

        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        }
        return false;
    }


    private static int fibo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n -2);
    }

}