import java.util.*;
import java.io.*;

public class Main {

    static int answer =0;
    static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        for(int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    
        int diff = Math.abs(A-B);
        for(int i =0; i<N; i++) {
            diff = Math.min(diff, Math.abs(arr[i]-B) +1);
        }
        System.out.println(diff);
    }


}