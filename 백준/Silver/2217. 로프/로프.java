import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer arr[] = new Integer[N];
        
        for(int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            
        }

        Arrays.sort(arr, Collections.reverseOrder());
        int answer = 0;
        int count =0;
        int index =0;
        while(true) {
            if(index >= N)
                break;
            if(count ==0) {
                answer = arr[index];
                count ++;
            }
            else if(count !=0) {
                count++;
                if(answer <= arr[index]*count) {
                    answer = arr[index]*count;
                } 
            }
            index++;
        }

        System.out.println(answer);
    }

}
