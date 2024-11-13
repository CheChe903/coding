import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main {
	static int arr[] = new int[10001];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		func();

		for(int i =0; i<N; i++) {
			int cur = Integer.parseInt(br.readLine());

			int p = cur /2;
			int q = cur /2;

			while(!(p==1)) {
				if(arr[p] == 0 && arr[q] == 0) {
					System.out.println(p +" "+q);
					break;
				}

				p--;
				q++;
			}
		}

	}

	static void func() {

		for(int i =2; i<10001; i++) {
		
			if(arr[i] == 0 ){
				for(int j = i+i; j<10001; j+=i) {
					arr[j] = 1;
				} 
			}
		}
	}
}
