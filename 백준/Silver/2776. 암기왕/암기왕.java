import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int T = Integer.parseInt(br.readLine());

        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i =0; i<T; i++) {

            HashSet<Integer> set = new HashSet<>();
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j<N; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for(int j =0; j<M; j++) {  
                if(set.contains(Integer.parseInt(st.nextToken()))) {
                    sb.append(1 +"\n");
                }
                else
                    sb.append(0+"\n");

            }
        }
        
        System.out.println(sb);
        
    }
}
