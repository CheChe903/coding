import java.io.*;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            Stack<Character> goodWord = new Stack<>();
            for(int j = 0; j < line.length(); j++) {
                if(!goodWord.isEmpty() && goodWord.peek() == line.charAt(j)) {
                    goodWord.pop();
                }else {
                    goodWord.push(line.charAt(j));
                }
            }
            if(goodWord.isEmpty()) count++;
        }
        System.out.println(count);
    }
}