import java.io.*;
import java.util.*;

public class Main {

    static char[] arr;
    static int[] pair;
    static TreeSet<String> set;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        arr = input.toCharArray();

        pair = new int[arr.length];

        Stack<Integer> stack = new Stack<>();
        
        for(int i =0; i<arr.length; i++) {
            if(arr[i] == '(') {
                stack.push(i);
            }

            else if(arr[i] ==')') {
                pair[i] =stack.peek();
                pair[stack.peek()] =i;
                stack.pop();
            }
        }

        set = new TreeSet();
        visited = new boolean[arr.length];
        
        dfs(0,arr.length);

        set.remove(input);

        StringBuilder sb = new StringBuilder();
        set.stream().forEach(ans -> sb.append(ans).append("\n"));
        System.out.println(sb);
    }

    static void dfs(int idx, int len ) {
        if(idx == len) {
            print();
            return;
        }


        if(arr[idx]=='(') {
            visited[idx] =true;
            visited[pair[idx]] =true;

            dfs(idx+1,len);

            visited[idx]= false;
            visited[pair[idx]]= false;
        }

        dfs(idx+1,len);
    }
    static void print() {
        String tmp = "";
        for(int i = 0;i <arr.length; i++) {
            if(!visited[i])
                tmp +=arr[i];
        }
        set.add(tmp);
    }

}