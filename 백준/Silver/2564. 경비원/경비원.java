import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x= Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());    

        Queue<int []> queue = new LinkedList<>();

        for(int i =0; i <N; i++) {
            st = new StringTokenizer(br.readLine());

            int currentX = Integer.parseInt(st.nextToken());
            int currentY = Integer.parseInt(st.nextToken());

            queue.add(new int[] {currentX, currentY});
        }

        st = new StringTokenizer(br.readLine());

        int dongX = Integer.parseInt(st.nextToken());
        int dongY = Integer.parseInt(st.nextToken());

        int ans = 0;


        while(!queue.isEmpty()) {

            int now[] = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            if(dongX == nowX) {
                ans += Math.abs(dongY-nowY);
            }

            else if(Math.abs(dongX - nowX) == 1 &&(dongX * nowX == 2 || dongX * nowX == 12)) {
                
                if(dongX ==2 || nowX == 2) {
                    ans = Math.min(ans + y + dongY + nowY, ans + y + (x- dongY) + (x-nowY));
                }
                else {
                    ans = Math.min(ans + x + dongY + nowY, ans + x + (y- dongY) + (y-nowY)); 
                }
            }
            else {
                if(dongX * nowX ==3) {
                    ans += (dongY + nowY);
                }  
                else if(dongX * nowX ==4) {
                    if(dongX ==1) {
                        ans += ((x- dongY)+ nowY);
                    }
                    else{
                        ans += (dongY + (x-nowY));
                    }
                }
                else if(dongX * nowX == 6) {
                    if(dongX ==2) {
                        ans += (dongY + (y-nowY));
                    }
                    else {
                        ans +=((y-dongY) + nowY);
                    }
                }
                else if(dongX * nowX == 8) {
                    if(dongX == 2) {
                        ans += ((x-dongY) + (y-nowY));
                    }
                    else {
                        ans += ((y-dongY) + (x- nowY));
                    }
                }
            }
        }

        System.out.println(ans);

    }
}