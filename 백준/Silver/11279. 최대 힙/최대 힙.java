import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main {
 
	public static long C;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

		for(int i =0; i<N; i++) {

			int cur = Integer.parseInt(br.readLine());

			if(cur ==0 ) {
				if(!pq.isEmpty()) {
					System.out.println(pq.poll());
				}
				else
					System.out.println(0);
			}
			else {
				pq.add(cur);
			}
		}
	}

	
}