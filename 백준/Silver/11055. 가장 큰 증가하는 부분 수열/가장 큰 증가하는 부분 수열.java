import java.util.*;
import java.io.*;

public class Main {
	static int arr[][];
	static int N;
	static int answerMinus =0;
	static int answerZero = 0;
	static int answerOne = 0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N+1];

		int dp[] = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[1] = arr[1];
        for (int i = 1; i <= N; i++) {
            dp[i] = arr[i];
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
                }
            }
        }
		int max = Integer.MIN_VALUE;
		for(int i : dp) {
			max = Math.max(i,max);
		}
		System.out.println(max);



	}
}
