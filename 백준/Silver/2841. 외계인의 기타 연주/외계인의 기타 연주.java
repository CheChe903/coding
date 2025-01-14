import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer> stack[];
        stack = new Stack[7];

        for(int i =1; i<=6; i++) {
            stack[i] = new Stack<>();
        }
        int ans = 0;

        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int currentLine = Integer.parseInt(st.nextToken());
            int currentP = Integer.parseInt(st.nextToken());

            if(stack[currentLine].isEmpty()) {
                ans+=1;
                stack[currentLine].add(currentP);
            }
            else {
                while(!stack[currentLine].isEmpty() && stack[currentLine].peek() > currentP) {
                    stack[currentLine].pop();
                    ans+=1;
                }

                if(!stack[currentLine].isEmpty()) {
                    if(stack[currentLine].peek() == currentP) {
                        continue;
                    }
                    else if(stack[currentLine].peek() < currentP) {
                        ans+=1;
                        stack[currentLine].add(currentP);
                    }
                }
                else {
                    stack[currentLine].add(currentP);
                    ans+=1;
                }
            }
        }

        System.out.println(ans);

    
    }

}