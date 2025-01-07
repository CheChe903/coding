import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static String S;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=  Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        S = br.readLine();

        int answer = 0;

        for(int i =0; i<S.length(); i++) {
            if(S.charAt(i) == 'I') {
                if(check(i)) {
                    answer+=1;
                }
            }
        }

        System.out.println(answer);
    }
    static boolean check(int startIndex) {
        int oCount = 0;

        int maxLength = N*2 +1;
        boolean checking = true;
        for(int i = startIndex; i< startIndex+ maxLength; i++) {
            if(i > S.length()-1) {
                checking = false;
                break;
            }
            if(i != startIndex &&i > 0 && S.charAt(i)  == S.charAt(i-1)) {
                checking = false;
                break;
            }
            if(S.charAt(i) == 'O') {
                oCount+=1;
            }
        }

        if(oCount == N && checking) {
            return true;
        }
        return false;
    }
}
