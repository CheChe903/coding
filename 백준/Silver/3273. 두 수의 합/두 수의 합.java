import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt( br.readLine());
        int arr[] = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer =0;
        for(int i =1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int start =1;
        int end = N;
        
        while(start < end) {
            if(arr[start] + arr[end] == x) {
                answer ++;
                if(start +1 <end && arr[start+1] == arr[start]) {
                    start++;
                }
                else if( end -1 >start && arr[end-1]==arr[end]) {
                    end--;
                }
                else {
                    start ++;
                    end --;
                }
            }
            else if(arr[start] + arr[end] > x) {
                end--;
            }
            else if(arr[start] + arr[end] <x) {
                start++;
            }
        }


        System.out.println(answer);
    }
}
