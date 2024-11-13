import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main {
 
	static int arr[][];
	static int answerZero;
	static int answerOne;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		arr = new int[N+1][N+1];

		for(int i =1; i<=N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j =1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answerOne =0;
		answerZero =0;

		func(1,1, N);

		System.out.println(answerZero);
		System.out.println(answerOne);
	}

	static void func(int xIndex, int yIndex ,int length) {

		if(check(xIndex, xIndex+ length-1,yIndex,yIndex+ length-1 )) {
			if(arr[xIndex][yIndex]==0) {
				answerZero++;
			}
			else {
				answerOne++;
			}
		}
		else {
			func(xIndex + length/2, yIndex, length/2);
			func(xIndex, yIndex+length/2, length/2);
			func(xIndex, yIndex, length/2);
			func(xIndex+length/2, yIndex+length/2, length/2);
		}
	}


	static boolean check(int startX, int endX, int startY, int endY) {
		
		int zero = 0;
		int one = 0;
		for(int i = startX; i<=endX; i++) {
			for(int j = startY; j<=endY; j++) {
				if(arr[i][j] == 0) {
					if(one == 0 ){
						zero++;
					}
					else
						return false;
				}
				else if(arr[i][j] == 1) {
					if(zero ==0) {
						one ++;
					}
					else
						return false;
				}
			}
		}
		return true;
	}
}
