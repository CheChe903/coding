import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[10001];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i =2; i<=10000; i++) {
            if(arr[i] ==0) {
                arrayList.add(i);
                for(int j = i+i; j<=10000; j+=i) {
                    arr[j] =1;
                }
            }
        }
        int answer = 0;
        for(int i =0; i<arrayList.size()-1; i++) {
            if(arrayList.get(i) * arrayList.get(i+1) > N) {
                System.out.println(arrayList.get(i) * arrayList.get(i+1));
                break;
            }
        }
        
    }  

}
