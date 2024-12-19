import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String input = br.readLine();
        char[] duck = {'q','u','a','c','k'};
        int answer =0;
        boolean visited[] = new boolean[input.length()];
        int index= 0;

        if(input.charAt(0) != 'q' && input.length()%5 != 0) {
            System.out.println(-1);
            System.exit(0);
        }
        for(int i =0; i<input.length(); i++) {
            List<Character> list  = new ArrayList<>();

            for(int j =i; j<input.length(); j++) {
                if(!visited[j] && input.charAt(j) == duck[index]) {
                    index++;
                    list.add(input.charAt(j));
                    visited[j] =true;
                    if(index==5)
                        index= 0;
                }
            }

            if(list.size() !=0) {
                if(list.get(list.size()-1) != 'k') {
                    System.out.println(-1);
                    System.exit(0);
                }
                answer+=1;
            }
        }
        for(int i =0; i<input.length(); i++) {
            if(visited[i] == false) {
                System.out.println(-1);
                System.exit(0);
            }
        }
        System.out.println(answer);


    }
}