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

		arr = new int[N+1][N+1];

		StringTokenizer st;
		for(int i =1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(1,1,N);

		System.out.println(answerMinus);
		System.out.println(answerZero);
		System.out.println(answerOne);
	
	}
	static void dfs(int startX, int startY, int length) {

		if(check(startX, startY, length)) {
			if(arr[startX][startY]== 1) {
				answerOne++;
			}
			else if(arr[startX][startY]== -1) {
				answerMinus++;
			}
			else
				answerZero++;
			return;
		}

		dfs(startX, startY, length/3);
		dfs(startX+length/3, startY, length/3);
		dfs(startX+length/3*2, startY, length/3);
		dfs(startX, startY+length/3, length/3);
		dfs(startX, startY+length/3*2, length/3);
		dfs(startX+length/3, startY+length/3, length/3);
		dfs(startX+length/3*2, startY+length/3, length/3);
		dfs(startX+length/3, startY+length/3*2, length/3);
		dfs(startX+length/3*2, startY+length/3*2, length/3);





	}

	static boolean check(int startX, int startY, int length) {
		int minusOne= 0;
		int zero = 0;
		int one =0;

		for(int i = startX; i<= startX+length-1; i++) {
			for(int j = startY; j<=startY+length-1; j++) {
				if(arr[i][j]== 0 ) {
					zero++;
					if(minusOne !=0 || one !=0 )
						return false;
				}
				else if(arr[i][j] == 1) {
					one++;
					if(minusOne != 0 || zero != 0)
						return false;
				}
				else {
					minusOne++;
					if(zero !=0 || one != 0)
						return false;
				}
			}
		}

		return true;


	}
}

