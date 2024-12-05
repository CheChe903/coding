import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String input = br.readLine();

        if(isPali(input)) {
            System.out.println(input.length());
            System.exit(0);
        }

        for(int i = 0; i<input.length()-1; i++) {
            String checkString = input + reverse(i, input);

            if(isPali(checkString)) {
                System.out.println(checkString.length());
                System.exit(0);
            }
        }
    }

    static boolean isPali(String str) {


        int start = 0;
        int end = str.length()-1;

        while(start<=end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    static String reverse(int length, String str) {

        String newString = "";

        for(int i = length; i>=0; i--) {
            newString += str.charAt(i) +"";
        }
        return newString;
    }
}