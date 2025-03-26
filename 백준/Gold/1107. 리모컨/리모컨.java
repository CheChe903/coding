import java.io.*;
import java.util.*;

public class Main {
    static Set<Integer> destroyedButton;
    static int answer;
    static int N,M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        destroyedButton = new HashSet<>();
        if(M>0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<M; i++) {
                int but = Integer.parseInt(st.nextToken());
                destroyedButton.add(but);		
            }
        }
        

        if(N ==100) {
            System.out.println(0);
            return;
        }
        answer = Math.abs(N -100);
		
        dfs(0,0);
        System.out.println(answer);
    }

    static void dfs(int index, int click) {

        for(int i =0; i<10; i++) {
            if(!destroyedButton.contains(i)) {
                int newBtn = click * 10 + i;
                int cnt = Math.abs(N - newBtn) + String.valueOf(newBtn).length();
                answer = Math.min(cnt, answer);
                if(index< 6) {
                    dfs(index+1, newBtn);
                }
            }
            
        }
    }
}