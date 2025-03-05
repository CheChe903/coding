import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int mod = 0;
        for(int i =0; i<T; i++) {

            String oper = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();

            mod = 0;
            String numbers = input.replace("[", "").replace("]", "");

            String numbersList[] = numbers.split(",");
        
            boolean error = false;
            Deque<Integer> deque = new ArrayDeque<>();

            for(int j = 0; j<N; j++) {
                deque.addLast(Integer.parseInt(numbersList[j]));
            }
            
            for(int j=0; j<oper.length(); j++) {

                if(oper.charAt(j) =='R') {
                    if(mod == 1) 
                        mod =0;
                    else
                        mod =1;
                }
                else if(oper.charAt(j) =='D') {
                    if(deque.isEmpty()) {
                        error = true;
                        break;

                    }
                    if(mod==0) {
                        deque.removeFirst();
                    }
                    else {
                        deque.removeLast();
                    }
                }
            }
            StringBuilder sb = new StringBuilder("[");
            if(error == true) {
                System.out.println("error");
                continue;
            }
            if(mod == 0) {
                while(!deque.isEmpty()) {
                    sb.append(deque.removeFirst());
                    if(!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
            }
            else {
                while(!deque.isEmpty()) {
                    sb.append(deque.removeLast());
                    if(!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
            }
            sb.append("]");

            System.out.println(sb);
        }
    }

}