import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][3];  // [i][0]: 배치X, [i][1]: 왼쪽, [i][2]: 오른쪽
        
        // 초기값 설정
        dp[1][0] = 1;  // 사자를 배치하지 않는 경우
        dp[1][1] = 1;  // 왼쪽에 배치하는 경우
        dp[1][2] = 1;  // 오른쪽에 배치하는 경우
        
        // dp 진행
        for(int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;  // 현재 줄에 배치X
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;  // 현재 줄 왼쪽에 배치
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;  // 현재 줄 오른쪽에 배치
        }
        
        // 최종 결과 계산
        int answer = (dp[N][0] + dp[N][1] + dp[N][2]) % 9901;
        System.out.println(answer);
    }
}