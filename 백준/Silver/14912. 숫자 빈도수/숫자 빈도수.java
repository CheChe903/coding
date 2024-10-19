import java.util.*;
import java.io.*;

public class Main {

    static int answer =0;
    static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[10];
        StringTokenizer st  =new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i =1; i<=n; i++) {
            int cur = i;

            while(!(cur ==0)){
                int cur2 = cur%10;
                arr[cur2]++;
                cur = cur/10;
            }

        }
        System.out.println(arr[d]);
    }


}