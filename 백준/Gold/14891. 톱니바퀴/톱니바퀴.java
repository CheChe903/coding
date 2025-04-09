import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean visited[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list = new ArrayList[5];
    

        for(int i =1; i<=4; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i =1; i<=4;i++) {
            String input = br.readLine();
            for(int j =0; j< input.length(); j ++) {
                list[i].add(Integer.parseInt(input.charAt(j) +""));
            }
        }

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i =0; i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            visited= new boolean[5];
            func(num, dir);
        }

        int answer = 0;
        if(list[1].get(0) ==1) {
            answer+=1;
        }
        if(list[2].get(0) ==1) {
            answer+=2;
        }
        if(list[3].get(0) ==1) {
            answer+=4;
        }
        if(list[4].get(0) ==1) {
            answer+=8;
        }

        System.out.println(answer);
    }

    static void func(int num, int dir){
        
        if(num == 0 || num == 5) {
            return;
        }

        int secondIndex = list[num].get(2);
        int sixthIndex = list[num].get(6);
        if(dir == 1) {
            list[num].add(0, list[num].remove(list[num].size() - 1));

        }
        else {
            list[num].add(list[num].remove(0));
        }

        visited[num] = true;
        if(num -1 >=1 && visited[num-1] == false) {
            if(sixthIndex != list[num-1].get(2)) {
                func(num-1, dir == -1 ? 1:-1);
            }
            
        }
        if(num +1 <=4 && visited[num+1]== false) {
            if(secondIndex != list[num+1].get(6)) {
                func(num+1, dir == -1 ? 1:-1);
            }
        }
        
    }


}