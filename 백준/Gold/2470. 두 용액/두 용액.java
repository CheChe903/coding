import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[N];

        for(int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start =0;
        int end = N-1;
        int currentValue = arr[start] + arr[end];
        int answer = currentValue;
        int startAnswer = arr[start];
        int endAnswer = arr[end];
        while(start<end) {

            if(Math.abs(answer) > Math.abs(currentValue)) {
                answer = currentValue;
                startAnswer = arr[start];
                endAnswer= arr[end];
            }

            if(currentValue < 0) {
                start++;
            }
            else if(currentValue >0) {
                end--;
            }
            else {
                startAnswer = arr[start];
                endAnswer= arr[end];
                break;
                
            }

            currentValue = arr[start] + arr[end];
        }

        System.out.println(startAnswer +" " + endAnswer);

    /*
     * 정렬 -> 투포인터 -> 둘을 더 한 값이 -면 start++, +면 end--;
     * -99, -2, -1, 4, 98
     */
    }
}