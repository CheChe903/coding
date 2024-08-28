import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int pay[] = new int[N+1];
        int day[] = new int[N+1];

        int max[] = new int[N+2];

        for(int i =1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            pay[i]= Integer.parseInt(st.nextToken());
        }

        if(day[N] == 1)
            max[N] = pay[N];
        for(int i =N; i>=1; i--) {
            int next = i + day[i];

            if(next > N +1) {
                max[i] = max[i+1];
            }
            else
                max[i] = Math.max(max[i+1], max[i+day[i]]+pay[i]);
        }

        System.out.println(max[1]);

    }

}
