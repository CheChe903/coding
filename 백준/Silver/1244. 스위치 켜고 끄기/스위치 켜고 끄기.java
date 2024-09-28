import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
            
        int K = Integer.parseInt(br.readLine());

        for(int i =0; i<K; i++) {
            st = new StringTokenizer(br.readLine());

            int sex = Integer.parseInt(st.nextToken());
            int butNum = Integer.parseInt(st.nextToken());

            if(sex == 1) {
                for(int j = butNum; j <=N; j+=butNum) {
                    if(arr[j]== 1)
                        arr[j]=0;
                    else
                        arr[j]=1;
                }
            }
            else if(sex ==2) {
                if(arr[butNum]== 1)
                    arr[butNum] = 0;
                else
                    arr[butNum] =1;

                int left = butNum-1;
                int right = butNum+1;

                while(left >=1 && right <=N && arr[left] == arr[right]) {
                    if(arr[left] ==1) {
                        arr[left] =0;
                        arr[right] =0;
                    }
                    else {
                        arr[left] =1;
                        arr[right] = 1;
                        
                    }
                    left--;
                    right++;
              
                } 
            }

        }

        for(int i=1; i<=N; i++) {
            System.out.print(arr[i] +" ");
            
            if(i%20 ==0) {
                System.out.println();
            }
        }
    }
}