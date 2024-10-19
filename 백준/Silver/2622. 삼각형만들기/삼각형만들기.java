import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        // 9 - > 4 5 - > 4 2 3 / 4 1 4
        //       3 6 - > 3 3 3
            
        // 8 - > 4 4 - > 4 2 2
        //       3 5 - > 2 3 3
    
        int answer =0;
        for(int i =1; i<N; i++) {
            for(int j = i; j<N; j++) {
                int cur = N - (i +j);
                
                if(cur < i || cur <j) 
                    break;   
                else if(cur < i + j)
                    answer++;
                
            }
        }
        System.out.println(answer);
        
    }


}