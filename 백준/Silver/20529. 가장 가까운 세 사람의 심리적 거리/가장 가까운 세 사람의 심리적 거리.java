import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i =0; i<T; i++) {
            int N= Integer.parseInt(br.readLine());

            String input = br.readLine();

            String[] MBTI = input.split(" ");

            int min = Integer.MAX_VALUE;
            
            if(N> 32) {
                sb.append(0).append("\n");
                continue;
            }

            for(int j = 0; j<N; j++) {
                for(int k = j+1; k <N; k++) {
                    
                    for(int l = k+1; l <N; l++) {
                        int cnt = 0;
                        
                        for(int m = 0; m<4; m++) {
                            cnt += MBTI[j].charAt(m) != MBTI[k].charAt(m) ? 1 :0;
                            cnt += MBTI[j].charAt(m) != MBTI[l].charAt(m) ? 1 :0;
                            cnt += MBTI[k].charAt(m) != MBTI[l].charAt(m) ? 1 :0;
                        }
                        min = Math.min(min, cnt);
                        if(min ==0) break;
                    }
                }
            }

            sb.append(min).append("\n");


        }
        System.out.println(sb);
    }
}