import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> A[];
    static boolean visited[];
    static int parent[];
    static int N,answer;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int arr[]= new int[N];
        long start = 0;
        long end = -1;
        long answer = 0;
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, arr[i]);
        }

        while(start<= end) {
            long mid = (start+end)/2;
            long count = 0;
            for(int i =0; i<N; i++) {
                if(arr[i] > mid){
                    count = count + (arr[i]- mid);
                }
            }

            if(count >=M) {
                start = mid +1;
                answer = Math.max(answer, mid);
            }
            else if(count <M) {
                end = mid -1;
            }
        }

        System.out.println(answer);
    }



}

