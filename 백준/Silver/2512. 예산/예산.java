import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int arr[] = new int[N];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i=0 ;i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max=  Math.max(arr[i],max);
		}
		min = 0;
		int M = Integer.parseInt(br.readLine());

		int answer = 0;
		while(min<=max) {

			int mid = (min+max)/2;
			int count  = 0;
			for(int i =0; i<N; i++) {
		
				count += Math.min(arr[i],mid);
			}

			if(count > M ) {
				max = mid-1;
			}
			else {
				min =mid+1;
				answer =mid;
			}
		}

		
		System.out.println(answer);
		
	}

}
