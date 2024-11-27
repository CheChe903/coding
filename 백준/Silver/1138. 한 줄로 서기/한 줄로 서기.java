import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int arr[] = new int[N+1];

        for(int i = 1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer[] = new int[N+1];

        for(int i = 1; i<=N; i++) {
            
            for(int j = 1; j<=N; j++) {
                if(arr[i] == 0 && answer[j] == 0) {
                    answer[j] = i;
                    break;
                }
                else if(answer[j]== 0) {
                    arr[i]--;
                }
            }
        }

        for(int i =1; i<=N; i++) {
            System.out.print(answer[i] +" ");
        }

    }
}