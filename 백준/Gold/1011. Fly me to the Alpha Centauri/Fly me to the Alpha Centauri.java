import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i =0; i<T; i++) {
            st = new StringTokenizer(br.readLine());

            int x=  Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

			int distance = y-x;
			
			int max = (int)Math.sqrt(distance);
            
			if(max == Math.sqrt(distance)) {
				System.out.println(max * 2 - 1);
			}
			else if(distance <= max * max + max) {
				System.out.println(max * 2);
			}
			else {
				System.out.println(max * 2 + 1);
			}
        }
    }
}