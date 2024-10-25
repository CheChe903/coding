import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Integer arr[] = new Integer[M];
        int maxPrice =-1;
        int minPrice =Integer.MAX_VALUE;
        for(int i =0; i<M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxPrice = Math.max(maxPrice, arr[i]);
            minPrice = Math.min(minPrice, arr[i]);
        }

        Arrays.sort(arr, Collections.reverseOrder());
        int answer = 0;
        int answerPrice = 0;
        for(int i =minPrice; i <=maxPrice; i++) {
            int price =i;
            int count = 0;
            for(int j =0; j<M;j++) {
                if(N==j)
                    break;
                
                if(arr[j]>=i) {
                    count += i;
                    
                }                
            }
            if(answer <= count){
                answer = count;
                answerPrice = price;
            }
        }
        System.out.println(answerPrice+" "+answer);
    }
}
