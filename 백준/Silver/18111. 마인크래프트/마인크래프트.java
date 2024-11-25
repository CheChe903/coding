import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int[][] ground = new int[N][M];
        int minHeight = 256;
        int maxHeight = 0;
        
        // 입력받으면서 최소, 최대 높이 계산
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(minHeight, ground[i][j]);
                maxHeight = Math.max(maxHeight, ground[i][j]);
            }
        }
        
        int answerTime = Integer.MAX_VALUE;
        int answerHeight = 0;
        
        for(int height = minHeight; height <= maxHeight; height++) {
            int time = 0;
            int inventory = B;
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    int diff = ground[i][j] - height;
                    
                    if(diff > 0) {
                        time += diff * 2;
                        inventory += diff;
                    } else if(diff < 0) { 
                        time += Math.abs(diff);
                        inventory -= Math.abs(diff);
                    }
                }
            }
            
            
            if(inventory >= 0) {
                if(time <= answerTime) {
                    answerTime = time;
                    answerHeight = height;
                }
            }
        }
        
        System.out.println(answerTime + " " + answerHeight);
    }
}