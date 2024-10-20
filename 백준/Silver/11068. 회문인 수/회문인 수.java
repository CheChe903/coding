import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int number = Integer.parseInt(br.readLine());
            boolean isPalindromeInAnyBase = false;

            
            for (int base = 2; base <= 64; base++) {
                String converted = convertToBase(number, base);
                
                if (isPalindrome(converted)) {
                    isPalindromeInAnyBase = true;
                    break;
                }
            }

            if (isPalindromeInAnyBase) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.print(sb);
    }

    public static String convertToBase(int num, int base) {
        StringBuilder sb = new StringBuilder();
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";

        while (num > 0) {
            sb.append(chars.charAt(num % base)); 
            num /= base;
        }

        return sb.reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
