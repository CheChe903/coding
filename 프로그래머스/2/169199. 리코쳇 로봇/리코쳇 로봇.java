import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static String[] mystr;
    static int[][] visited;
    static int myx;
    static int myy;
    public int solution(String[] board) {
        int answer = 0;
        mystr = board;
        myx = 0;
        myy = 0;
        int answerx = 0;
        int answery = 0;

        int width = board.length;
        int height = board[0].length();

        visited = new int[width][height];
        for (int i = 0; i < mystr.length; i++) {
            for (int j = 0; j < mystr[0].length(); j++) {
                if (mystr[i].charAt(j) == 'R') {
                    myx = i;
                    myy = j;
                   
                } else if (mystr[i].charAt(j) == 'G') {
                    answerx = i;
                    answery = j;
                }
            }
        }

        bfs(myx, myy);
        
        for(int i=0; i<board.length; i++)
        {
            for(int j =0; j<board[i].length(); j++)
            {
                System.out.print(visited[i][j]+" ");
         
            }
            //
            //..R 
            //... 
            //... 
            //..D 
            //DG.
            System.out.print("\n");
        }
        if(visited[answerx][answery] ==0)
            return -1;
        else
            return visited[answerx][answery];
    }

    static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        
        while (!queue.isEmpty()) {
            
            int[] now = queue.poll();
            int nowx = now[0];
            int nowy = now[1];
            for (int i = 0; i < 4; i++) {
                int nx = nowx;
                int ny = nowy;
                while (nx >= 0 && nx < mystr.length && ny >= 0 && ny < mystr[nx].length() && mystr[nx].charAt(ny) != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }
                nx -= dx[i];
                ny -= dy[i];
                    
                if(nx >= 0 && ny >= 0 && nx < mystr.length && ny < mystr[nx].length())
                {
                    
                    if (visited[nx][ny] == 0 && mystr[nx].charAt(ny) !='R') 
                    {
                        
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = visited[nowx][nowy] + 1;
                    }
                }

            }
        }
    }
}
