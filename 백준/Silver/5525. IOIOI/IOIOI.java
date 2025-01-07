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
        int currentLength = 0;
        boolean oTime= false;
        boolean iTime = true;
        for(int i =0; i<S.length(); i++) {
            if(iTime && !oTime && S.charAt(i) =='I') {
                currentLength+=1;
                iTime = false;
                oTime = true;
            }
            else if(!iTime && oTime && S.charAt(i) == 'O') {
                currentLength+=1;
                iTime = true;
                oTime = false;
            }
            else {
                if(currentLength >= N*2+1) {
                    answer += (currentLength - (2*N+1)) / 2 + 1;
                }
                if(S.charAt(i) == 'I') { 
                    currentLength = 1;
                    iTime = false;
                    oTime = true;
                } else {
                    currentLength = 0;
                    iTime = true;
                    oTime = false;
                }
            }
        }

        if(currentLength >= N*2+1) {
            answer += (currentLength - (2*N+1)) / 2 + 1;
        }

        System.out.println(answer);
    }
}