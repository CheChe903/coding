import java.io.*;
import java.util.*;

class Node {
    private final int value;
    private final int index;

    Node(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }
}
public class Main {
    
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            
        }

        StringBuilder sb = new StringBuilder();

        Stack<Node>stack = new Stack<>();
        for(int i =1; i<=N; i++) {

            while(!stack.isEmpty() && stack.peek().getValue() < arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                sb.append("0 ");
            }
            else {
                sb.append(stack.peek().getIndex()+" ");
            }
            stack.push(new Node(arr[i], i));
        }

        System.out.println(sb);
    }
}