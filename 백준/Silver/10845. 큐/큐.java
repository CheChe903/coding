import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int back = -1;
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            if(command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
                back = num;
            }
            else if(command.equals("pop")) {
                if(!queue.isEmpty()) {
                    sb.append(queue.poll()).append('\n');
                    if(queue.isEmpty()) {
                        back = -1;
                    }
                }
                else {
                    sb.append(-1).append('\n');
                }
            }
            else if(command.equals("size")) {
                sb.append(queue.size()).append('\n');
            }
            else if(command.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append('\n');
            }
            else if(command.equals("front")) {
                if(!queue.isEmpty()) {
                    sb.append(queue.peek()).append('\n');
                }
                else {
                    sb.append(-1).append('\n');
                }
            }
            else if(command.equals("back")) {
                if(!queue.isEmpty()) {
                    sb.append(back).append('\n');
                }
                else {
                    sb.append(-1).append('\n');
                }
            }
        }
        
        System.out.print(sb.toString());
        br.close();
    }
}