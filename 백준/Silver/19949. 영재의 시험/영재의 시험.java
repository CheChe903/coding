import java.io.*;
import java.util.*;



public class Main {
    static int arr[], young[];
    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[10];
        young = new int[10];

        for(int i =0; i<10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        dfs(0);
        System.out.println(answer);

    }

    static void dfs(int depth) {

        if(depth == 10) {
            int count  =0;

            for(int i =0; i<10; i++) {
                if(arr[i] == young[i]) {
                    count+=1;
                }
            }

            if(count >=5) {
                answer+=1;
            }

            return;
        }


        for(int i =1; i<=5; i++) {
            if(depth>=2) {
                if(young[depth-1] == i && young[depth-2] == i) 
                    continue;
            }

            young[depth] = i;
            dfs(depth+1);
        }

    }
}
