import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int n = Integer.parseInt(br.readLine());
        int answer = -1;
        ArrayList<Integer> answerList = new ArrayList<>();

        for(int i = 1; i<=n; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            list.add(n);
            list.add(i);
            int count = 2;
            int index= 2;
            while(true) {
                int cur = list.get(index-2) - list.get(index-1);
                if(cur<0) 
                    break;
                count++;
                index++;
                list.add(cur);
            }

            if(answer < count){
                answer = count;
                answerList= list;
            }

        }

        System.out.println(answer);
        for(int i : answerList) {
            System.out.print(i +" ");
        }

    }

}